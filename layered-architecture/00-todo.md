# TODO - Layered Architecture

## Naming

- [ ] Renombrar `PokeApiExternalService` / `PokeApiExternalServiceImpl` a `PokemonClient` / `PokemonClientImpl` (o similar) para que no haya confusion con el nombre del API externo y sea agnostico al proveedor
- [ ] Separar DTOs externos de internos: mover `PokeApiPokemonDTO` a un subpaquete `dto/external` o `client/dto`
- [ ] Renombrar `PokeApiPokemonDTO` a `PokemonClientDTO` o similar

## Error Handling

- [ ] Reemplazar `assert pokeApiPokemonDto != null` por una excepcion propia (e.g. `PokemonNotFoundException`)
- [ ] Agregar manejo de errores especificos en `GlobalExceptionHandler` (404 para pokemon no encontrado, timeout, etc.)
- [ ] Agregar validacion de input en el controller (`@Valid`, `@NotBlank`)
- [ ] Manejar errores de red y HTTP del RestTemplate (try-catch o `RestTemplate` error handler)

## Testing

- [ ] Agregar unit tests para `PokemonServiceImpl`
- [ ] Agregar unit tests para `PokeApiExternalServiceImpl` (mockear RestTemplate)
- [ ] Agregar integration tests para `PokemonController`
- [ ] Agregar test para escenarios de error (pokemon no encontrado, API caida, etc.)

## Configuracion

- [ ] Externalizar la URL de PokeAPI a `application.yaml` en vez de hardcodearla
- [ ] Configurar timeouts y retry en RestTemplate
- [ ] Cambiar `ddl-auto: create-drop` por algo mas apropiado (e.g. `validate` + migraciones)

## Otros

- [ ] Agregar logging (`@Slf4j`)
- [ ] Agregar `@Transactional` donde falte
