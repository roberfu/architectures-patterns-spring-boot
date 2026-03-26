package cl.springmachine.layered.service.impl;

import cl.springmachine.layered.entity.PokemonEntity;
import cl.springmachine.layered.repository.PokemonRepository;
import cl.springmachine.layered.service.PokemonClientExternalService;
import cl.springmachine.layered.service.PokemonService;
import cl.springmachine.layered.service.dto.PokemonClientDto;
import cl.springmachine.layered.service.dto.PokemonDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;

    private final PokemonClientExternalService pokeApiService;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, PokemonClientExternalService pokeApiService) {
        this.pokemonRepository = pokemonRepository;
        this.pokeApiService = pokeApiService;
    }

    @Override
    @Transactional
    public Integer savePokemon(String name) {
        PokemonClientDto pokeApiPokemonDTO = pokeApiService.getPokemonInfo(name);
        PokemonDto pokemonDTO = PokemonDto.builder()
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
    public PokemonDto getPokemon(Integer pokedexNumber) {
        Optional<PokemonEntity> optional = pokemonRepository.findById(Objects.requireNonNull(pokedexNumber));
        return optional.map(pokemonEntity -> PokemonDto.builder()
                .pokedexNumber(pokemonEntity.getPokedexNumber())
                .name(pokemonEntity.getName())
                .type(pokemonEntity.getType())
                .build()).orElse(null);
    }

}
