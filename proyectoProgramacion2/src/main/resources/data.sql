-- Seed data
PRAGMA foreign_keys = OFF;

-- Editorials
INSERT INTO editorial(nombre,pais,direccion,telefono,email) VALUES('Editorial Uno','Argentina','Calle Falsa 123','123456','uno@example.com');
INSERT INTO editorial(nombre,pais,direccion,telefono,email) VALUES('Editorial Dos','Chile','Av Siempreviva 456','654321','dos@example.com');
INSERT INTO editorial(nombre,pais,direccion,telefono,email) VALUES('Editorial Tres','Uruguay','Rambla 10','111222','tres@example.com');

-- Authors
INSERT INTO autor(nombre,fechaDeFallecimiento,nacionalidad) VALUES('Gabriel Garcia','06-03-1927','Colombiana');
INSERT INTO autor(nombre,fechaDeFallecimiento,nacionalidad) VALUES('Jorge Luis Borges','24-08-1899','Argentina');
INSERT INTO autor(nombre,fechaDeFallecimiento,nacionalidad) VALUES('Isabel Allende','02-08-1942','Chilena');

-- Books
INSERT INTO libro(isbn,titulo,editorial_id,anioPublicacion,autor_id) VALUES('978-1','Cien Años de Soledad',1,1967,1);
INSERT INTO libro(isbn,titulo,editorial_id,anioPublicacion,autor_id) VALUES('978-2','Ficciones',2,1944,2);
INSERT INTO libro(isbn,titulo,editorial_id,anioPublicacion,autor_id) VALUES('978-3','La Casa de los Espíritus',3,1982,3);

-- Ejemplares
INSERT INTO ejemplar(libro_id) VALUES(1);
INSERT INTO ejemplar(libro_id) VALUES(1);
INSERT INTO ejemplar(libro_id) VALUES(2);
INSERT INTO ejemplar(libro_id) VALUES(3);
INSERT INTO ejemplar(libro_id) VALUES(3);

-- Personas (clients and staff)
INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES('Juan','Perez','01-01-1980','555-0001','juan@example.com',20123456);
INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES('Ana','Gomez','04-05-1990','555-0002','ana@example.com',20987654);
INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES('Laura','Lopez','02-02-1975','555-1000','laura@example.com',30123456);
INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES('Carlos','Diaz','10-06-1982','555-1001','carlos@example.com',30123457);
INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES('Mario','Rossi','12-11-1970','555-3000','mario@example.com',40123456);

-- Clientes: associate persona_id, legajo, reserved_books
INSERT INTO cliente(persona_id,legajo,reserved_books) VALUES(1,5001,0);
INSERT INTO cliente(persona_id,legajo,reserved_books) VALUES(2,5002,1);

-- Bibliotecarios / Administradores
INSERT INTO bibliotecario(persona_id,legajo,is_admin) VALUES(3,1001,1);
INSERT INTO bibliotecario(persona_id,legajo,is_admin) VALUES(4,2001,0);

-- Biblioteca
INSERT INTO biblioteca(nombre,direccion,telefono,email,administrador_id) VALUES('Biblioteca Central','Plaza 1','555-2000','central@example.com',1);

-- Prestamos
INSERT INTO prestamo(ejemplar_id,cliente_id,fechaInicio,fechaDevolucion) VALUES(1,1,'01-09-2025',NULL);
INSERT INTO prestamo(ejemplar_id,cliente_id,fechaInicio,fechaDevolucion) VALUES(4,1,'05-09-2025',NULL);
INSERT INTO prestamo(ejemplar_id,cliente_id,fechaInicio,fechaDevolucion) VALUES(2,1,'10-06-2025','01-07-2025');

INSERT INTO prestamo(ejemplar_id,cliente_id,fechaInicio,fechaDevolucion) VALUES(2,2,'15-07-2025','01-08-2025');
INSERT INTO prestamo(ejemplar_id,cliente_id,fechaInicio,fechaDevolucion) VALUES(3,2,'20-08-2025',NULL);
INSERT INTO prestamo(ejemplar_id,cliente_id,fechaInicio,fechaDevolucion) VALUES(5,2,'01-05-2025','20-05-2025');

PRAGMA foreign_keys = ON;
