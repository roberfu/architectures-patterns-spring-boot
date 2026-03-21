package cl.springmachine.layered.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.springmachine.layered.dto.PokeApiPokemonDTO;
import cl.springmachine.layered.dto.PokemonDTO;
import cl.springmachine.layered.entity.PokemonEntity;
import cl.springmachine.layered.repository.PokemonRepository;
import cl.springmachine.layered.service.PokeApiExternalService;
import cl.springmachine.layered.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;

    private final PokeApiExternalService pokeApiService;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, PokeApiExternalService pokeApiService) {
        this.pokemonRepository = pokemonRepository;
        this.pokeApiService = pokeApiService;
    }

    @Override
    @Transactional
    public Integer savePokemon(String name) {
        PokeApiPokemonDTO pokeApiPokemonDTO = pokeApiService.getPokemonInfo(name);
        PokemonDTO pokemonDTO = PokemonDTO.builder()
                .name(pokeApiPokemonDTO.getName())
                .pokedexNumber(pokeApiPokemonDTO.getId())
                .type(pokeApiPokemonDTO.getTypes()
                        .stream().findFirst().map(pokemonType -> pokemonType.getType().getName()).orElseThrow())
                .build();

        PokemonEntity entity = Objects.requireNonNull(PokemonEntity.builder()
                .type(pokemonDTO.getType())
                .name(pokemonDTO.getName())
                .pokedexNumber(pokemonDTO.getPokedexNumber())
                .build());

        return pokemonRepository.save(entity).getPokedexNumber();
    }

    @Override
    public PokemonDTO getPokemon(Integer pokedexNumber) {
        Optional<PokemonEntity> optional = pokemonRepository.findById(Objects.requireNonNull(pokedexNumber));
        return optional.map(pokemonEntity -> PokemonDTO.builder()
                .pokedexNumber(pokemonEntity.getPokedexNumber())
                .name(pokemonEntity.getName())
                .type(pokemonEntity.getType())
                .build()).orElse(null);
    }

}
