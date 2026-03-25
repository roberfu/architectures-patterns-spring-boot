package cl.springmachine.hexagonal.core.ports.inbound;

public interface CreatePokemonUseCasePort {

    Integer createPokemon(String name);
}
