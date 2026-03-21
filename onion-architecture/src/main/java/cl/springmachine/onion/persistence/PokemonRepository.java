package cl.springmachine.onion.persistence;

import java.util.Objects;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.springmachine.onion.domain.pokemon.Pokemon;
import cl.springmachine.onion.domain.service.PokemonProvider;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer>, PokemonProvider {

	default Integer createPokemon(Pokemon pokemon) {
		PokemonEntity entity = save(
				new PokemonEntity(pokemon.getPokedexNumber(), pokemon.getName(), pokemon.getType()));
		return entity.getPokedexNumber();
	}

	default Pokemon readPokemon(Integer pokedexNumber) {
		Optional<PokemonEntity> optional = findById(Objects.requireNonNull(pokedexNumber));
		return optional.map(
				t -> Pokemon.builder().pokedexNumber(t.getPokedexNumber()).name(t.getName()).type(t.getType()).build())
				.orElse(null);
	}

}
