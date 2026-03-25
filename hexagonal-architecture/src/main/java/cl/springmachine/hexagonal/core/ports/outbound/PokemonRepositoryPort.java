package cl.springmachine.hexagonal.core.ports.outbound;

import cl.springmachine.hexagonal.core.application.domain.pokemon.Pokemon;

public interface PokemonRepositoryPort {

    Integer savePokemon(Pokemon pokemon);

    Pokemon getPokemon(Integer number);
}
