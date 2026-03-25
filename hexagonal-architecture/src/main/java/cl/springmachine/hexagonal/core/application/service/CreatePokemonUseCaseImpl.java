package cl.springmachine.hexagonal.core.application.service;

import cl.springmachine.hexagonal.core.application.domain.pokemon.Pokemon;
import cl.springmachine.hexagonal.core.ports.inbound.CreatePokemonUseCasePort;
import cl.springmachine.hexagonal.core.ports.outbound.PokemonClientServicePort;
import cl.springmachine.hexagonal.core.ports.outbound.PokemonRepositoryPort;

public class CreatePokemonUseCaseImpl implements CreatePokemonUseCasePort {

    private final PokemonRepositoryPort repositoryPort;

    private final PokemonClientServicePort pokemonClientServicePort;

    public CreatePokemonUseCaseImpl(PokemonRepositoryPort repositoryPort,
                                    PokemonClientServicePort pokemonClientServicePort) {
        this.repositoryPort = repositoryPort;
        this.pokemonClientServicePort = pokemonClientServicePort;
    }

    @Override
    public Integer createPokemon(String name) {
        Pokemon pokemon = getPokemonClientData(name);
        return repositoryPort.savePokemon(pokemon);
    }

    private Pokemon getPokemonClientData(String name) {
        return pokemonClientServicePort.getPokemonData(name);
    }

}
