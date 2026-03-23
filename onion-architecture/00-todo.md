# TODO - Onion Architecture

## Naming

- [ ] Renombrar `PokeApiRestClient` a algo agnostico al proveedor como `PokemonExternalClient` o `PokemonRestClient`
- [ ] Renombrar `PokeApiPokemonDto` a `PokemonExternalDto` o `PokemonClientDto`
- [ ] `ExternalPokeApiProvider` en dominio — renombrar a `ExternalPokemonProvider` (agnostico al proveedor)

## Error Handling

- [ ] Reemplazar `assert pokeApiPokemonDto != null` en `PokeApiRestClient` por excepcion propia
- [ ] `PokemonRepository.getPokemon()` retorna `null` con `.orElse(null)` — usar Optional o lanzar excepcion
- [ ] No hay null check en `PokemonController` al leer pokemon — puede causar NPE
- [ ] `.orElseThrow()` sin mensaje en `PokemonService` — agregar excepcion descriptiva
- [ ] Agregar `GlobalExceptionHandler`
- [ ] Agregar validacion de input en el controller

## Consistencia de API

- [ ] POST retorna `Map<String, Integer>` y GET retorna `PokemonDto` — unificar formato de respuesta

## Testing

- [ ] Agregar unit tests para `PokemonService`
- [ ] Agregar unit tests para `PokeApiRestClient`
- [ ] Agregar integration tests para el controller
- [ ] Agregar test para escenarios de error

## Configuracion

- [ ] Externalizar la URL de PokeAPI a `application.yaml`
- [ ] Configurar timeouts y retry en RestTemplate
