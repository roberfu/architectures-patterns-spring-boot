package cl.springmachine.hexagonal.application.service;

import org.springframework.stereotype.Service;

import cl.springmachine.hexagonal.application.domain.pokemon.Pokemon;
import cl.springmachine.hexagonal.application.usecases.CreatePokemonUseCase;
import cl.springmachine.hexagonal.ports.outbound.ClientPokemonDto;
import cl.springmachine.hexagonal.ports.outbound.PokemonClientServicePort;
import cl.springmachine.hexagonal.ports.outbound.PokemonRepositoryPort;

@Service
public class CreatePokemonUseCaseImpl implements CreatePokemonUseCase {

	private final PokemonRepositoryPort repositoryPort;

	private final PokemonClientServicePort pokemonClientServicePort;

	public CreatePokemonUseCaseImpl(PokemonRepositoryPort repositoryPort,
			PokemonClientServicePort pokemonClientServicePort) {
		this.repositoryPort = repositoryPort;
		this.pokemonClientServicePort = pokemonClientServicePort;
	}

	@Override
	public Integer createPokemon(String name) {
		Pokemon pokemon = getClientPokemonDto(name);

		return repositoryPort.savePokemon(Pokemon.builder().name(pokemon.getName())
				.pokedexNumber(pokemon.getPokedexNumber()).type(pokemon.getType()).build());
	}

	private Pokemon getClientPokemonDto(String name) {
		ClientPokemonDto clientPokemonDto = pokemonClientServicePort.getClientPokemonInfo(name);

		return Pokemon.builder().name(clientPokemonDto.getName()).pokedexNumber(clientPokemonDto.getId())
				.type(clientPokemonDto.getTypes().stream().findFirst()
						.map(pokemonType -> pokemonType.getType().getName()).orElseThrow())
				.build();
	}

}
