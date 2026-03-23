# TODO - Hexagonal Architecture

## Arquitectura

- [ ] Hacer el core/application verdaderamente agnostico: quitar `@Service` de los use case impls (`CreatePokemonUseCaseImpl`, `ReadPokemonUseCaseImpl`) y registrar los beans via configuracion
- [ ] El dominio (`Pokemon.java`) usa Lombok — evaluar si es aceptable o si deberia ser POJO puro
- [ ] Renombrar `JpaRepositoryAdapter` (es una interfaz, no un adapter) a `PokemonJpaRepository` o `PokemonSpringDataRepository`

## Bugs

- [ ] **BUG**: En `PokemonRestControllerAdapter` se asigna `.pokedexNumber()` dos veces en el builder del GET (linea 42-43) — eliminar la duplicada

## Naming

- [ ] Renombrar `PokemonClientServiceAdapter` / `PokemonClientServicePort` a algo mas claro como `PokemonExternalClient` / `PokemonExternalClientPort` para que sea agnostico al proveedor (PokeAPI)
- [ ] Renombrar `ClientPokemonDto` a `PokemonClientDto` o `PokemonExternalDto` (consistencia de naming)
- [ ] Metodo privado `getClientPokemonDto()` en `CreatePokemonUseCaseImpl` retorna un `Pokemon`, no un DTO — renombrarlo a `fetchPokemonFromExternal()` o similar

## Consistencia de API

- [ ] POST `/pokemon/{name}` retorna `Map<String, Integer>` y GET retorna `PokemonDto` — unificar formato de respuesta

## Error Handling

- [ ] Reemplazar `assert clientPokemonDto != null` por excepcion propia
- [ ] Agregar `GlobalExceptionHandler` (no existe actualmente)
- [ ] `PokemonRepositoryAdapter.getPokemon()` retorna `null` con `.orElse(null)` — usar Optional o lanzar excepcion
- [ ] Agregar validacion de input en el controller
- [ ] Manejar errores de red/HTTP del RestTemplate

## Testing

- [ ] Agregar unit tests para los use cases
- [ ] Agregar unit tests para los adapters
- [ ] Agregar integration tests para el controller
- [ ] Agregar test para escenarios de error

## Configuracion

- [ ] Externalizar la URL de PokeAPI a `application.yaml`
- [ ] Configurar timeouts y retry en RestTemplate
