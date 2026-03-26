package cl.springmachine.hexagonal.application.service;

import cl.springmachine.hexagonal.application.domain.pokemon.Pokemon;
import cl.springmachine.hexagonal.application.ports.inbound.GetPokemonUseCasePort;
import cl.springmachine.hexagonal.application.ports.outbound.PokemonRepositoryPort;

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
