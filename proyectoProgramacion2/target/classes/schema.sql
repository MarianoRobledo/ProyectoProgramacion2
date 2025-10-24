-- Schema for biblioteca (SQLite)
PRAGMA foreign_keys = ON;

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
  fechaDeFallecimiento TEXT,
  nacionalidad TEXT
);

CREATE TABLE IF NOT EXISTS libro (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  isbn TEXT,
  titulo TEXT NOT NULL,
  editorial_id INTEGER,
  anioPublicacion INTEGER,
  autor_id INTEGER,
  disponible INTEGER DEFAULT 1,
  visible BOOLEAN DEFAULT TRUE,
  FOREIGN KEY(editorial_id) REFERENCES editorial(id),
  FOREIGN KEY(autor_id) REFERENCES autor(id)
);

CREATE TABLE IF NOT EXISTS ejemplar (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  libro_id INTEGER NOT NULL,
  FOREIGN KEY(libro_id) REFERENCES libro(id)
);

CREATE TABLE IF NOT EXISTS cliente (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  persona_id INTEGER,
  legajo INTEGER,
  reserved_books INTEGER DEFAULT 0,
  FOREIGN KEY(persona_id) REFERENCES persona(id)
);

CREATE TABLE IF NOT EXISTS prestamo (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  ejemplar_id INTEGER NOT NULL,
  cliente_id INTEGER NOT NULL,
  fechaInicio TEXT,
  fechaDevolucion TEXT,
  FOREIGN KEY(ejemplar_id) REFERENCES ejemplar(id),
  FOREIGN KEY(cliente_id) REFERENCES cliente(id)
);

-- Persona / Bibliotecario / Administrador
CREATE TABLE IF NOT EXISTS persona (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre TEXT NOT NULL,
  apellido TEXT,
  fechaNacimiento TEXT,
  telefono TEXT,
  email TEXT,
  dni INTEGER
);

CREATE TABLE IF NOT EXISTS bibliotecario (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  persona_id INTEGER NOT NULL,
  legajo INTEGER,
  is_admin INTEGER DEFAULT 0,
  FOREIGN KEY(persona_id) REFERENCES persona(id)
);

CREATE TABLE IF NOT EXISTS biblioteca (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre TEXT NOT NULL,
  direccion TEXT,
  telefono TEXT,
  email TEXT,
  administrador_id INTEGER,
  FOREIGN KEY(administrador_id) REFERENCES bibliotecario(id)
);
