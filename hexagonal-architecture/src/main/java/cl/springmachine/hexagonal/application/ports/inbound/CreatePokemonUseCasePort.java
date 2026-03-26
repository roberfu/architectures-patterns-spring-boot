package cl.springmachine.hexagonal.application.ports.inbound;

public interface CreatePokemonUseCasePort {

    Integer createPokemon(String name);
}
