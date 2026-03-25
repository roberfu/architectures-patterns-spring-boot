package cl.springmachine.hexagonal.core.application.service;

import cl.springmachine.hexagonal.core.application.domain.pokemon.Pokemon;
import cl.springmachine.hexagonal.core.ports.inbound.GetPokemonUseCasePort;
import cl.springmachine.hexagonal.core.ports.outbound.PokemonRepositoryPort;

public class GetPokemonUseCaseImpl implements GetPokemonUseCasePort {

    private final PokemonRepositoryPort repositoryPort;

    public GetPokemonUseCaseImpl(PokemonRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Pokemon getPokemon(Integer number) {
        return repositoryPort.getPokemon(number);
    }
}
