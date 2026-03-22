package cl.springmachine.hexagonal.ports.outbound;

public interface PokemonClientServicePort {
	ClientPokemonDto getClientPokemonInfo(String name);
}
