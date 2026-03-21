package cl.springmachine.hexagonal.application.service;

import cl.springmachine.hexagonal.application.domain.pokemon.Pokemon;
import cl.springmachine.hexagonal.application.usecases.ReadPokemonUseCase;
import cl.springmachine.hexagonal.ports.outbound.PokemonRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ReadPokemonUseCaseImpl implements ReadPokemonUseCase {

    private final PokemonRepositoryPort repositoryPort;

    public ReadPokemonUseCaseImpl(PokemonRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Pokemon readPokemon(Integer pokedexNumber) {
        return repositoryPort.getPokemon(pokedexNumber);
    }
}
