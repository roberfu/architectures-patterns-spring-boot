package cl.springmachine.hexagonal.adapters.outbound;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.springmachine.hexagonal.ports.outbound.ClientPokemonDto;
import cl.springmachine.hexagonal.ports.outbound.PokemonClientServicePort;

@Service
public class PokemonClientServiceAdapter implements PokemonClientServicePort {

	private final RestTemplate restTemplate;

	public PokemonClientServiceAdapter(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public ClientPokemonDto getClientPokemonInfo(String name) {
		String url = "https://pokeapi.co/api/v2/pokemon/" + name;
		ClientPokemonDto clientPokemonDto = restTemplate.getForObject(url, ClientPokemonDto.class);
		assert clientPokemonDto != null;
		return clientPokemonDto;
	}
}
