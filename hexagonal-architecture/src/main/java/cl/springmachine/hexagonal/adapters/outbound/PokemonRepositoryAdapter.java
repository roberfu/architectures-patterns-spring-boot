package cl.springmachine.hexagonal.adapters.outbound;

import cl.springmachine.hexagonal.adapters.outbound.entity.PokemonEntity;
import cl.springmachine.hexagonal.application.domain.pokemon.Pokemon;
import cl.springmachine.hexagonal.application.ports.outbound.PokemonRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
public class PokemonRepositoryAdapter implements PokemonRepositoryPort {

    private final JpaRepositoryAdapter repositoryAdapter;

    public PokemonRepositoryAdapter(JpaRepositoryAdapter repositoryAdapter) {
        this.repositoryAdapter = repositoryAdapter;
    }

    @Override
    public Integer savePokemon(Pokemon pokemon) {
        PokemonEntity entity = Objects.requireNonNull(PokemonEntity.builder()
                .name(pokemon.name())
                .type(pokemon.type())
                .pokedexNumber(Integer.parseInt(pokemon.pokedexNumber()))
                .build());

        return repositoryAdapter.save(entity).getPokedexNumber();
    }

    @Override
    public Pokemon getPokemon(Integer pokedexNumber) {
        Optional<PokemonEntity> optional = repositoryAdapter.findByPokedexNumber(pokedexNumber);
        return optional.map(pokemonEntity -> new Pokemon(pokemonEntity.getName(),
                pokemonEntity.getPokedexNumber().toString(), pokemonEntity.getType())).orElse(null);
    }

}
