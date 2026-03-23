# TODO - Software Architectures in Spring Boot

Resumen de proyectos que tienen pendientes por resolver.

## Proyectos con TODOs

- **[clean-architecture](./clean-architecture/00-todo.md)** — Dominio acoplado a JPA, use case retorna DTO de presenter, naming de PokeAPI
- **[hexagonal-architecture](./hexagonal-architecture/00-todo.md)** — Core no es agnostico (Spring annotations), bug de campo duplicado en builder, naming de client
- **[onion-architecture](./onion-architecture/00-todo.md)** — Naming de PokeAPI, error handling, tests
- **[layered-architecture](./layered-architecture/00-todo.md)** — Naming de PokeAPI, error handling, tests
- **[custom-architecture](./custom-architecture/00-todo.md)** — Naming de DTO del client, inconsistencia en respuestas, tests

## Temas comunes a todos los proyectos

- Renombrar referencias a "PokeApi" en nombres de clases/metodos para que sean agnosticos al proveedor
- Reemplazar `assert != null` por excepciones propias en todos los clients
- Agregar tests (ninguno tiene tests reales)
- Externalizar URL de PokeAPI a configuracion
- Agregar `GlobalExceptionHandler` donde falte
- Configurar timeouts/retry en RestTemplate
