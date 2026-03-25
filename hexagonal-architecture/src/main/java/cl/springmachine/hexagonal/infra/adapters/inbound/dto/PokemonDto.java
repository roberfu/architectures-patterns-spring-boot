package cl.springmachine.hexagonal.infra.adapters.inbound.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PokemonDto(@JsonProperty(value = "pokemon_name") String name,
                         @JsonProperty(value = "pokedex_number") String number,
                         @JsonProperty(value = "pokemon_type") String type) {
}
