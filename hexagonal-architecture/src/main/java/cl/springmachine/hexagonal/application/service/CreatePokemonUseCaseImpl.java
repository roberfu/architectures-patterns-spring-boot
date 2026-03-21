package cl.springmachine.hexagonal.application.service;

import org.springframework.stereotype.Service;

import cl.springmachine.hexagonal.adapters.outbound.PokeApiPokemonDto;
import cl.springmachine.hexagonal.application.domain.pokemon.Pokemon;
import cl.springmachine.hexagonal.application.usecases.CreatePokemonUseCase;
import cl.springmachine.hexagonal.ports.inbound.PokemonDto;
import cl.springmachine.hexagonal.ports.outbound.PokeApiServicePort;
import cl.springmachine.hexagonal.ports.outbound.PokemonRepositoryPort;

@Service
public class CreatePokemonUseCaseImpl implements CreatePokemonUseCase {

    private final PokemonRepositoryPort repositoryPort;

    private final PokeApiServicePort pokeApiServicePort;

    public CreatePokemonUseCaseImpl(PokemonRepositoryPort repositoryPort, PokeApiServicePort pokeApiServicePort) {
        this.repositoryPort = repositoryPort;
        this.pokeApiServicePort = pokeApiServicePort;
    }

    @Override
    public Integer createPokemon(String name) {
        PokeApiPokemonDto pokeApiPokemonDto = pokeApiServicePort.getPokemonInfoPokeApi(name);

        PokemonDto pokemon = PokemonDto.builder()
                .name(pokeApiPokemonDto.getName())
                .pokedexNumber(pokeApiPokemonDto.getId())
                .type(pokeApiPokemonDto.getTypes()
                        .stream().findFirst().map(pokemonType -> pokemonType.getType().getName()).orElseThrow())
                .build();

        return repositoryPort.savePokemon(Pokemon.builder()
                .name(pokemon.getName())
                .pokedexNumber(pokemon.getPokedexNumber())
                .type(pokemon.getType())
                .build());
    }
}
