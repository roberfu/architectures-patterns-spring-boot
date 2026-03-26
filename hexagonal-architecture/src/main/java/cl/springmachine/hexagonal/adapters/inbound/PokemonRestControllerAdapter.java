package cl.springmachine.hexagonal.adapters.inbound;

import cl.springmachine.hexagonal.adapters.inbound.dto.PokemonDto;
import cl.springmachine.hexagonal.application.ports.inbound.CreatePokemonUseCasePort;
import cl.springmachine.hexagonal.application.ports.inbound.GetPokemonUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pokemon")
public class PokemonRestControllerAdapter {

    private final CreatePokemonUseCasePort createPokemonUseCase;

    private final GetPokemonUseCasePort getPokemonUseCase;

    public PokemonRestControllerAdapter(CreatePokemonUseCasePort createPokemonUseCase,
                                        GetPokemonUseCasePort getPokemonUseCase) {
        this.createPokemonUseCase = createPokemonUseCase;
        this.getPokemonUseCase = getPokemonUseCase;
    }

    @PostMapping("/{name}")
    public ResponseEntity<Map<String, Integer>> savePokemon(@PathVariable String name) {
        Map<String, Integer> response = new HashMap<>();
        response.put("pokedex_number",
                createPokemonUseCase.createPokemon(name));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{number}")
    public ResponseEntity<PokemonDto> getPokemon(@PathVariable Integer number) {
        var pokemon = getPokemonUseCase.getPokemon(number);
        PokemonDto response = new PokemonDto(pokemon.name(), pokemon.pokedexNumber(), pokemon.type());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
