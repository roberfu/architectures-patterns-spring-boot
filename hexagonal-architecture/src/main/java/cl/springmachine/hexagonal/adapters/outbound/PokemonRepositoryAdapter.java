package cl.springmachine.hexagonal.adapters.outbound;

import cl.springmachine.hexagonal.core.domain.pokemon.Pokemon;
import cl.springmachine.hexagonal.ports.outbound.PokemonRepositoryPort;
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
                .name(pokemon.getName())
                .type(pokemon.getType())
                .pokedexNumber(pokemon.getPokedexNumber())
                .build());

        return repositoryAdapter.save(entity).getPokedexNumber();
    }

    @Override
    public Pokemon getPokemon(Integer pokedexNumber) {
        Optional<PokemonEntity> optional = repositoryAdapter.findByPokedexNumber(pokedexNumber);
        return optional.map(pokemonEntity -> Pokemon.builder()
                .name(pokemonEntity.getName())
                .type(pokemonEntity.getType())
                .pokedexNumber(pokemonEntity.getPokedexNumber())
                .build()).orElse(null);
    }

}
