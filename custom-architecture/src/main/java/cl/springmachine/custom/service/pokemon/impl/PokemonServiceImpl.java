package cl.springmachine.custom.service.pokemon.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.springmachine.custom.client.pokeapi.PokeApiClient;
import cl.springmachine.custom.client.pokeapi.dto.PokemonPokeApiDTO;
import cl.springmachine.custom.repository.PokemonRepository;
import cl.springmachine.custom.repository.model.PokemonEntity;
import cl.springmachine.custom.service.pokemon.PokemonService;
import cl.springmachine.custom.service.pokemon.dto.PokemonDTO;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokeApiClient pokeApiClient;

    private final PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokeApiClient pokeApiClient, PokemonRepository pokemonRepository) {
        this.pokeApiClient = pokeApiClient;
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Integer savePokemon(String name) {
        PokemonPokeApiDTO pokemonPokeApiDTO = pokeApiClient.getPokemonInfo(name);
        PokemonDTO pokemonDto = PokemonDTO.builder()
                .name(pokemonPokeApiDTO.getName())
                .pokedexNumber(pokemonPokeApiDTO.getId())
                .type(pokemonPokeApiDTO.getTypes()
                        .stream().findFirst().map(pokemonType -> pokemonType.getType().getName()).orElseThrow())
                .build();

        PokemonEntity entity = Objects.requireNonNull(PokemonEntity.builder()
                .type(pokemonDto.getType())
                .name(pokemonDto.getName())
                .pokedexNumber(pokemonDto.getPokedexNumber())
                .build());

        return pokemonRepository.save(entity).getPokedexNumber();
    }

    @Override
    public PokemonDTO getPokemon(Integer pokedexNumber) {
        Optional<PokemonEntity> optional = pokemonRepository.findByPokedexNumber(pokedexNumber);
        return optional.map(pokemonEntity -> PokemonDTO.builder()
                .pokedexNumber(pokemonEntity.getPokedexNumber())
                .name(pokemonEntity.getName())
                .type(pokemonEntity.getType())
                .build()).orElse(null);
    }

}
