package cl.springmachine.hexagonal.adapters.outbound.config;

import cl.springmachine.hexagonal.application.ports.outbound.PokemonClientServicePort;
import cl.springmachine.hexagonal.application.ports.outbound.PokemonRepositoryPort;
import cl.springmachine.hexagonal.application.service.CreatePokemonUseCaseImpl;
import cl.springmachine.hexagonal.application.service.GetPokemonUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {

    @Bean
    CreatePokemonUseCaseImpl createPokemonUseCase(PokemonRepositoryPort pokemonRepositoryPort,
                                                  PokemonClientServicePort pokemonClientServicePort) {
        return new CreatePokemonUseCaseImpl(pokemonRepositoryPort, pokemonClientServicePort);
    }

    @Bean
    GetPokemonUseCaseImpl getPokemonUseCase(PokemonRepositoryPort pokemonRepositoryPort) {
        return new GetPokemonUseCaseImpl(pokemonRepositoryPort);
    }
}
