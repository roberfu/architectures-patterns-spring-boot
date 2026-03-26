package cl.springmachine.hexagonal.application.ports.inbound;

import cl.springmachine.hexagonal.application.domain.pokemon.Pokemon;

public interface GetPokemonUseCasePort {

    Pokemon getPokemon(Integer number);
}
