package cl.springmachine.hexagonal.application.ports.outbound;

import cl.springmachine.hexagonal.application.domain.pokemon.Pokemon;

public interface PokemonRepositoryPort {

    Integer savePokemon(Pokemon pokemon);

    Pokemon getPokemon(Integer number);
}
