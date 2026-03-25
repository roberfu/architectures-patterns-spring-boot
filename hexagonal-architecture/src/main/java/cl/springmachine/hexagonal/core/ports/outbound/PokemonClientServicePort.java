package cl.springmachine.hexagonal.core.ports.outbound;

import cl.springmachine.hexagonal.core.application.domain.pokemon.Pokemon;

public interface PokemonClientServicePort {
    Pokemon getPokemonData(String name);
}
