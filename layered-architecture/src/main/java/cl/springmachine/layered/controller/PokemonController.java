package cl.springmachine.layered.controller;

import cl.springmachine.layered.service.PokemonService;
import cl.springmachine.layered.service.dto.PokemonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping("/{name}")
    ResponseEntity<Map<String, Integer>> savePokemon(@PathVariable String name) {
        Integer pokedexNumber = pokemonService.savePokemon(name);
        Map<String, Integer> response = new HashMap<>();
        response.put("pokedex_number", pokedexNumber);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{pokedexNumber}")
    ResponseEntity<PokemonDto> getPokemon(@PathVariable Integer pokedexNumber) {
        return new ResponseEntity<>(pokemonService.getPokemon(pokedexNumber), HttpStatus.OK);
    }

}
