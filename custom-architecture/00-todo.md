# TODO - Custom Architecture

## Naming

- [ ] Renombrar `PokemonPokeApiDTO` a `PokemonClientDTO` o `PokemonExternalDTO` (el paquete ya indica que es de pokeapi, el nombre de clase deberia ser agnostico)
- [ ] Inconsistencia en respuesta POST: usa `pokeDexNumber` (camelCase mixto) vs `pokedex_number` (snake_case) en el DTO — unificar
- [ ] Evaluar renombrar paquete `client/pokeapi` a `client/pokemon` para ser agnostico al proveedor

## Error Handling

- [ ] Reemplazar `assert pokeApiPokemonDto != null` en `PokeApiClientImpl` por excepcion propia
- [ ] `PokemonServiceImpl.getPokemon()` retorna `null` con `.orElse(null)` — usar Optional o lanzar excepcion
- [ ] No hay null check en `PokemonController` al leer pokemon — puede causar NPE
- [ ] `.orElseThrow()` sin mensaje en `PokemonServiceImpl` — agregar excepcion descriptiva
- [ ] Agregar `GlobalExceptionHandler`
- [ ] Agregar validacion de input en el controller
- [ ] Manejar `DataIntegrityViolationException` por unique constraints duplicados

## Testing

- [ ] Agregar unit tests para `PokemonServiceImpl`
- [ ] Agregar unit tests para `PokeApiClientImpl` (mockear RestTemplate)
- [ ] Agregar integration tests para `PokemonController`
- [ ] Agregar test para escenarios de error

## Configuracion

- [ ] Externalizar la URL de PokeAPI a `application.yaml`
- [ ] Configurar timeouts y retry en RestTemplate

## Otros

- [ ] `Objects.requireNonNull()` en el builder del entity es innecesario (builder nunca retorna null) — simplificar
