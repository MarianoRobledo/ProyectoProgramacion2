Biblioteca (Java, Spring Boot, SQLite)

Este proyecto es un scaffold mínimo para un sistema de administración de biblioteca usando Java, Spring Boot (MVC) y SQLite.

Características incluidas:
- Modelos básicos: Persona (roles), Editorial, Autor, Libro, Ejemplar, Prestamo.
- Persistencia en SQLite (archivo biblioteca.db).
- Interfaz web mínima con Thymeleaf: listar libros, crear/editar/eliminar (con control de roles simple).
- Inicialización de la base con `schema.sql` y `data.sql`.

Requisitos:
- Java 11 (o superior compatible con Spring Boot 2.7)
- Maven

Cómo ejecutar (Windows PowerShell):

1) Construir el proyecto:

	mvn -f .\pom.xml clean package

2) Ejecutar la aplicación:

	mvn -f .\pom.xml spring-boot:run

3) Abrir en el navegador:

	http://localhost:8080

Login demo:
- Juan (admin): juan@example.com
- Maria (bibliotecario): maria@example.com
- Carlos (cliente): carlos@example.com

Notas y siguientes pasos:
- Para autenticación real, integra Spring Security (no incluido en este scaffold mínimo).
- Añadir validaciones, manejo de errores, y pruebas unitarias.
