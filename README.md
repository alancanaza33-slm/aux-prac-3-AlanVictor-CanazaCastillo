# API REST - Biblioteca (Tecnologías Emergentes SIS-414)

Sistema backend desarrollado en Spring Boot para la administración de libros en memoria mediante una API REST.

## Endpoints Disponibles

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| **POST** | `/api/books` | Registrar un nuevo libro |
| **GET** | `/api/books` | Obtener la lista de todos los libros |
| **GET** | `/api/books/{id}` | Obtener un libro específico por su ID |
| **PUT** | `/api/books/{id}` | Actualizar la información de un libro existente |
| **DELETE** | `/api/books/{id}` | Eliminar un libro por su ID |

## Documentación Swagger / OpenAPI
La documentación interactiva de la API puede consultarse mediante Swagger UI ingresando a la siguiente ruta una vez iniciada la aplicación:
👉 `http://localhost:8080/swagger-ui/index.html`