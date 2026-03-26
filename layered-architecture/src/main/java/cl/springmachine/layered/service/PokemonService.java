package cl.springmachine.layered.service;

import cl.springmachine.layered.service.dto.PokemonDto;

public interface PokemonService {

    Integer savePokemon(String name);

    PokemonDto getPokemon(Integer pokedexNumber);

}
