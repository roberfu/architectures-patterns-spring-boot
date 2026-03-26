package cl.springmachine.layered.service;

import cl.springmachine.layered.service.dto.PokemonClientDto;

public interface PokemonClientExternalService {

    PokemonClientDto getPokemonInfo(String name);
}
