package cl.springmachine.hexagonal.application.usecases;

import cl.springmachine.hexagonal.application.domain.pokemon.Pokemon;

public interface ReadPokemonUseCase {

    Pokemon readPokemon(Integer pokedexNumber);
}
