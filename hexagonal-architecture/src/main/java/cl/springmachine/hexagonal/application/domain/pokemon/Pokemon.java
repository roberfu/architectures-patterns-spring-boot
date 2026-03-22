package cl.springmachine.hexagonal.application.domain.pokemon;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {

	private String name;

	private Integer pokedexNumber;

	private String type;

	public static class PokemonBuilder {
		public Pokemon build() {
			Objects.requireNonNull(name, "Name is required");
			Objects.requireNonNull(pokedexNumber, "Pokedex number is required");
			Objects.requireNonNull(type, "Type is required");
			return new Pokemon(name, pokedexNumber, type);
		}
	}

}
