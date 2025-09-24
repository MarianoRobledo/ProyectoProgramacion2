package com.proyectoprogramacion2;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private int isbn;
    private String titulo;
    private Editorial editorial;
    private int anioPublicacion;
    private Autor autor;
    private boolean disponible;
    private List<Ejemplar> ejemplares = new ArrayList<>();

    public Libro() {}

    public Libro(int isbn, String titulo, Editorial editorial, int anioPublicacion, Autor autor, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
        this.disponible = disponible;
    }

    public int getIsbn() { return isbn; }
    public void setIsbn(int isbn) { this.isbn = isbn; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Editorial getEditorial() { return editorial; }
    public void setEditorial(Editorial editorial) { this.editorial = editorial; }

    public int getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public List<Ejemplar> getEjemplares() { return ejemplares; }
    public void setEjemplares(List<Ejemplar> ejemplares) { this.ejemplares = ejemplares; }

    public void addEjemplar(Ejemplar e) {
        if (e != null) {
            ejemplares.add(e);
            e.setLibro(this);
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", editorial=" + editorial +
                ", anioPublicacion=" + anioPublicacion +
                ", autor=" + autor +
                ", disponible=" + disponible +
                '}';
    }
}
