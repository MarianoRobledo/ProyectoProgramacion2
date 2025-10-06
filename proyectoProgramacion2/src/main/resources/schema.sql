PRAGMA foreign_keys = ON;

CREATE TABLE IF NOT EXISTS persona (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre TEXT NOT NULL,
  apellido TEXT,
  fechaNacimiento TEXT,
  telefono TEXT,
  email TEXT,
  rol TEXT NOT NULL -- CLIENTE, BIBLIOTECARIO, ADMIN
);

CREATE TABLE IF NOT EXISTS editorial (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre TEXT NOT NULL,
  pais TEXT,
  direccion TEXT,
  telefono TEXT,
  email TEXT
);

CREATE TABLE IF NOT EXISTS autor (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre TEXT NOT NULL,
  nacionalidad TEXT,
  fechaFallecimiento TEXT
);

CREATE TABLE IF NOT EXISTS libro (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  isbn TEXT,
  titulo TEXT NOT NULL,
  editorial_id INTEGER,
  anioPublicacion INTEGER,
  autor_id INTEGER,
  disponible INTEGER DEFAULT 1,
  FOREIGN KEY(editorial_id) REFERENCES editorial(id),
  FOREIGN KEY(autor_id) REFERENCES autor(id)
);

CREATE TABLE IF NOT EXISTS ejemplar (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  libro_id INTEGER NOT NULL,
  disponible INTEGER DEFAULT 1,
  FOREIGN KEY(libro_id) REFERENCES libro(id)
);

CREATE TABLE IF NOT EXISTS prestamo (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  ejemplar_id INTEGER NOT NULL,
  cliente_id INTEGER NOT NULL,
  fechaInicio TEXT,
  fechaDevolucion TEXT,
  FOREIGN KEY(ejemplar_id) REFERENCES ejemplar(id),
  FOREIGN KEY(cliente_id) REFERENCES persona(id)
);
