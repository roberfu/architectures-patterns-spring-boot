# TODO - Clean Architecture

## Arquitectura (Critico)

- [ ] **Hacer el dominio agnostico a infraestructura**: `Pokemon.java` tiene anotaciones JPA (`@Entity`, `@Table`, `@Id`, etc.) — debe ser un POJO puro. Crear un `PokemonEntity` separado en infraestructura/persistence
- [ ] **Quitar `@Component` de `PokemonRepository`** (interfaz de dominio) — no deberia tener anotaciones de Spring en la capa de dominio
- [ ] **Quitar `@Component` de los use cases** (`CreatePokemonUseCaseImpl`, `ReadPokemonUseCaseImpl`) — registrar beans via configuracion
- [ ] **Violacion de dependencias**: `ReadPokemonUseCase` retorna `PokemonDto` (capa presenter) — el use case debe retornar el modelo de dominio, y el presenter lo transforma a DTO

## Naming

- [ ] Renombrar `ExternalPokeApiClient` / `ExternalPokeApiClientImpl` a algo agnostico al proveedor como `PokemonClient` / `PokemonClientImpl`
- [ ] Renombrar `PokemonExternalDto` a `PokemonClientDto` (consistencia)
- [ ] Corregir nombre de variable `createPokemonUserCase` en `PokemonController` (typo: deberia ser `createPokemonUseCase`)
- [ ] Renombrar metodo `postMethodName` en controller a algo descriptivo como `createPokemon`

## Error Handling

- [ ] Reemplazar `assert pokemon != null` en `ExternalPokeApiClientImpl` por excepcion propia
- [ ] `.orElseThrow()` sin mensaje en `CreatePokemonUseCaseImpl` — agregar excepcion descriptiva
- [ ] Agregar null check en `ReadPokemonUseCaseImpl` (puede lanzar NPE)
- [ ] Agregar `GlobalExceptionHandler`
- [ ] Agregar validacion de input en el controller

## Testing

- [ ] Agregar unit tests para los use cases
- [ ] Agregar unit tests para `ExternalPokeApiClientImpl`
- [ ] Agregar integration tests para el controller
- [ ] Agregar test para escenarios de error

## Configuracion

- [ ] Externalizar la URL de PokeAPI a `application.yaml`
- [ ] Configurar timeouts y retry en RestTemplate
