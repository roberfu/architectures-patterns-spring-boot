package cl.springmachine.hexagonal.application.ports.outbound;

import cl.springmachine.hexagonal.application.domain.pokemon.Pokemon;

public interface PokemonClientServicePort {
    Pokemon getPokemonData(String name);
}
