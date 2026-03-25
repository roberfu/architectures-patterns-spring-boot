package cl.springmachine.hexagonal.infra.adapters.outbound.config;

import cl.springmachine.hexagonal.core.application.service.CreatePokemonUseCaseImpl;
import cl.springmachine.hexagonal.core.application.service.GetPokemonUseCaseImpl;
import cl.springmachine.hexagonal.core.ports.outbound.PokemonClientServicePort;
import cl.springmachine.hexagonal.core.ports.outbound.PokemonRepositoryPort;
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
