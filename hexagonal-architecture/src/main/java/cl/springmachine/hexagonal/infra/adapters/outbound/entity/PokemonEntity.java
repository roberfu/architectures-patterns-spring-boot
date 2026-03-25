package cl.springmachine.hexagonal.infra.adapters.outbound.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pokemon")
public class PokemonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pokedex_number", unique = true)
    private Integer pokedexNumber;

    @Column(unique = true)
    private String name;

    private String type;

}
