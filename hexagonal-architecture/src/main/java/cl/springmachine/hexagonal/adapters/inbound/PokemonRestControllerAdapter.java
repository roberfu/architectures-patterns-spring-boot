package cl.springmachine.hexagonal.adapters.inbound;

import cl.springmachine.hexagonal.application.domain.pokemon.Pokemon;
import cl.springmachine.hexagonal.application.usecases.CreatePokemonUseCase;
import cl.springmachine.hexagonal.application.usecases.ReadPokemonUseCase;
import cl.springmachine.hexagonal.ports.inbound.PokemonDto;
import cl.springmachine.hexagonal.ports.inbound.PokemonRestControllerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pokemon")
public class PokemonRestControllerAdapter implements PokemonRestControllerPort {

    private final CreatePokemonUseCase createPokemonUseCase;

    private final ReadPokemonUseCase readPokemonUseCase;

    public PokemonRestControllerAdapter(CreatePokemonUseCase createPokemonUseCase,
            ReadPokemonUseCase readPokemonUseCase) {
        this.createPokemonUseCase = createPokemonUseCase;
        this.readPokemonUseCase = readPokemonUseCase;
    }

    @Override
    @PostMapping("/{name}")
    public ResponseEntity<Map<String, Integer>> savePokemon(@PathVariable String name) {
        Map<String, Integer> response = new HashMap<>();
        response.put("id",
                createPokemonUseCase.createPokemon(name));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{pokedexNumber}")
    public ResponseEntity<PokemonDto> getPokemon(@PathVariable Integer pokedexNumber) {
        Pokemon pokemon = readPokemonUseCase.readPokemon(pokedexNumber);
        PokemonDto response = PokemonDto.builder().pokedexNumber(pokemon.getPokedexNumber()).name(pokemon.getName())
                .pokedexNumber(pokemon.getPokedexNumber())
                .type(pokemon.getType()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
