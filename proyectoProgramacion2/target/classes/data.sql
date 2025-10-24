-- Seed data
PRAGMA foreign_keys = OFF;

-- Editorials
INSERT INTO editorial(nombre,pais,direccion,telefono,email) VALUES('Editorial Uno','Argentina','Calle Falsa 123','123456','uno@example.com');
INSERT INTO editorial(nombre,pais,direccion,telefono,email) VALUES('Editorial Dos','Chile','Av Siempreviva 456','654321','dos@example.com');
INSERT INTO editorial(nombre,pais,direccion,telefono,email) VALUES('Editorial Tres','Uruguay','Rambla 10','111222','tres@example.com');

-- Authors
INSERT INTO autor(nombre,fechaDeFallecimiento,nacionalidad) VALUES('Gabriel Garcia','1927-03-06','Colombiana');
INSERT INTO autor(nombre,fechaDeFallecimiento,nacionalidad) VALUES('Jorge Luis Borges','1899-08-24','Argentina');
INSERT INTO autor(nombre,fechaDeFallecimiento,nacionalidad) VALUES('Isabel Allende','1942-08-02','Chilena');

-- Books
INSERT INTO libro(isbn,titulo,editorial_id,anioPublicacion,autor_id,disponible) VALUES('978-1','Cien Años de Soledad',1,1967,1,1);
INSERT INTO libro(isbn,titulo,editorial_id,anioPublicacion,autor_id,disponible) VALUES('978-2','Ficciones',2,1944,2,1);
INSERT INTO libro(isbn,titulo,editorial_id,anioPublicacion,autor_id,disponible) VALUES('978-3','La Casa de los Espíritus',3,1982,3,1);

-- Ejemplares
INSERT INTO ejemplar(libro_id) VALUES(1);
INSERT INTO ejemplar(libro_id) VALUES(1);
INSERT INTO ejemplar(libro_id) VALUES(2);
INSERT INTO ejemplar(libro_id) VALUES(3);
INSERT INTO ejemplar(libro_id) VALUES(3);

-- Personas (clients and staff)
INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES('Juan','Perez','1980-01-01','555-0001','juan@example.com',20123456);
INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES('Ana','Gomez','1990-05-04','555-0002','ana@example.com',20987654);
INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES('Laura','Lopez','1975-02-02','555-1000','laura@example.com',30123456);
INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES('Carlos','Diaz','1982-06-10','555-1001','carlos@example.com',30123457);
INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES('Mario','Rossi','1970-11-12','555-3000','mario@example.com',40123456);

-- Clientes: associate persona_id, legajo, reserved_books
INSERT INTO cliente(persona_id,legajo,reserved_books) VALUES(1,5001,0);
INSERT INTO cliente(persona_id,legajo,reserved_books) VALUES(2,5002,1);

-- Bibliotecarios / Administradores
INSERT INTO bibliotecario(persona_id,legajo,is_admin) VALUES(3,1001,1);
INSERT INTO bibliotecario(persona_id,legajo,is_admin) VALUES(4,2001,0);

-- Biblioteca
INSERT INTO biblioteca(nombre,direccion,telefono,email,administrador_id) VALUES('Biblioteca Central','Plaza 1','555-2000','central@example.com',1);

-- Prestamos
INSERT INTO prestamo(ejemplar_id,cliente_id,fechaInicio,fechaDevolucion) VALUES(1,1,'2025-09-01',NULL);
INSERT INTO prestamo(ejemplar_id,cliente_id,fechaInicio,fechaDevolucion) VALUES(4,1,'2025-09-05',NULL);
INSERT INTO prestamo(ejemplar_id,cliente_id,fechaInicio,fechaDevolucion) VALUES(2,1,'2025-06-10','2025-07-01');

INSERT INTO prestamo(ejemplar_id,cliente_id,fechaInicio,fechaDevolucion) VALUES(2,2,'2025-07-15','2025-08-01');
INSERT INTO prestamo(ejemplar_id,cliente_id,fechaInicio,fechaDevolucion) VALUES(3,2,'2025-08-20',NULL);
INSERT INTO prestamo(ejemplar_id,cliente_id,fechaInicio,fechaDevolucion) VALUES(5,2,'2025-05-01','2025-05-20');

PRAGMA foreign_keys = ON;
