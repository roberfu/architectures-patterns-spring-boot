package cl.springmachine.hexagonal.ports.outbound;

import cl.springmachine.hexagonal.application.domain.pokemon.Pokemon;

public interface PokemonRepositoryPort {

    Integer savePokemon(Pokemon pokemon);

    Pokemon getPokemon(Integer pokedexNumber);
}
