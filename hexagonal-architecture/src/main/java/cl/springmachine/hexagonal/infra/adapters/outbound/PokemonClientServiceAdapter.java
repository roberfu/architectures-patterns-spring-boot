package cl.springmachine.hexagonal.infra.adapters.outbound;

import cl.springmachine.hexagonal.core.application.domain.pokemon.Pokemon;
import cl.springmachine.hexagonal.core.ports.outbound.PokemonClientServicePort;
import cl.springmachine.hexagonal.infra.adapters.outbound.dto.ClientPokemonDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonClientServiceAdapter implements PokemonClientServicePort {

    private final RestTemplate restTemplate;

    public PokemonClientServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Pokemon getPokemonData(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        ClientPokemonDto clientPokemonDto = restTemplate.getForObject(url, ClientPokemonDto.class);

        return new Pokemon(clientPokemonDto.getName(), clientPokemonDto.getId().toString(),
                clientPokemonDto.getTypes().stream().findFirst()
                        .map(pokemonType -> pokemonType.getType().getName()).orElseThrow());
    }
}
