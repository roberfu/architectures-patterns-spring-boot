package cl.springmachine.hexagonal.ports.outbound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientPokemonDto {

    private Integer id;

    private String name;

    private List<PokemonType> types;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PokemonType {
        private Integer slot;
        private Type type;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Type {
        private String name;
    }


}
