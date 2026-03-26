package cl.springmachine.layered.service.impl;

import cl.springmachine.layered.service.PokemonClientExternalService;
import cl.springmachine.layered.service.dto.PokemonClientDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonClientExternalServiceImpl implements PokemonClientExternalService {

    private final RestTemplate restTemplate;

    public PokemonClientExternalServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PokemonClientDto getPokemonInfo(String name) {

        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        PokemonClientDto pokeApiPokemonDto = restTemplate.getForObject(url, PokemonClientDto.class);
        assert pokeApiPokemonDto != null;
        return pokeApiPokemonDto;
    }
}
