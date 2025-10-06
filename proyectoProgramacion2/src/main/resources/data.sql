-- Personas (roles)
INSERT INTO persona (nombre, apellido, fechaNacimiento, telefono, email, rol) VALUES ('Juan','Perez','1980-01-01','12345678','juan@example.com','ADMIN');
INSERT INTO persona (nombre, apellido, fechaNacimiento, telefono, email, rol) VALUES ('Maria','Gomez','1990-05-10','87654321','maria@example.com','BIBLIOTECARIO');
INSERT INTO persona (nombre, apellido, fechaNacimiento, telefono, email, rol) VALUES ('Carlos','Lopez','2000-02-20','5551234','carlos@example.com','CLIENTE');

-- Editorial y autor
INSERT INTO editorial (nombre,pais,direccion,telefono,email) VALUES ('Editorial Uno','Argentina','Calle Falsa 123','0123456','editorial@example.com');
INSERT INTO autor (nombre,nacionalidad,fechaFallecimiento) VALUES ('Gabriel Garcia Marquez','Colombiana',NULL);

-- Libros
INSERT INTO libro (isbn,titulo,editorial_id,anioPublicacion,autor_id,disponible) VALUES ('978-1234567890','Cien Años de Soledad',1,1967,1,1);
INSERT INTO libro (isbn,titulo,editorial_id,anioPublicacion,autor_id,disponible) VALUES ('978-9876543210','El Amor en los Tiempos del Cólera',1,1985,1,1);

-- Ejemplares
INSERT INTO ejemplar (libro_id,disponible) VALUES (1,1);
INSERT INTO ejemplar (libro_id,disponible) VALUES (1,1);
INSERT INTO ejemplar (libro_id,disponible) VALUES (2,1);
