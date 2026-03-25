package cl.springmachine.hexagonal.core.ports.inbound;

import cl.springmachine.hexagonal.core.application.domain.pokemon.Pokemon;

public interface GetPokemonUseCasePort {

    Pokemon getPokemon(Integer number);
}
