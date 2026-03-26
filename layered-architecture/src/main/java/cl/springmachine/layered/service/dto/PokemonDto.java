package cl.springmachine.layered.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PokemonDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("pokedex_number")
    private Integer pokedexNumber;

    private String type;
}
