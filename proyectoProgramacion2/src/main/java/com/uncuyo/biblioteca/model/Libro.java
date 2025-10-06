package com.uncuyo.biblioteca.model;

public class Libro {
    private Integer id;
    private String isbn;
    private String titulo;
    private Integer editorialId;
    private Integer autorId;
    private Boolean disponible;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Integer getEditorialId() { return editorialId; }
    public void setEditorialId(Integer editorialId) { this.editorialId = editorialId; }
    public Integer getAutorId() { return autorId; }
    public void setAutorId(Integer autorId) { this.autorId = autorId; }
    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }
}
