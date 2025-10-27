package com.uncuyo.biblioteca.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;

public class Libro {
    private Long id;

    @Pattern(regexp = "^[0-9Xx\\-]{10,17}$", message = "ISBN inválido")
    private String isbn;

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 300, message = "El título es demasiado largo")
    private String titulo;

    @Min(value = 1, message = "Editorial inválida")
    private Long editorialId;

    private Integer anioPublicacion;

    @Min(value = 1, message = "Autor inválido")
    private Long autorId;

    private Boolean visible = Boolean.TRUE;
    private Integer nroEjemplares;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Long getEditorialId() { return editorialId; }
    public void setEditorialId(Long editorialId) { this.editorialId = editorialId; }
    public Integer getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(Integer anioPublicacion) { this.anioPublicacion = anioPublicacion; }
    public Long getAutorId() { return autorId; }
    public void setAutorId(Long autorId) { this.autorId = autorId; }
    public Boolean getVisible() { return visible; }
    public void setVisible(Boolean visible) { this.visible = visible; }
    public Integer getNroEjemplares() {
        return nroEjemplares;
    }
    public void setNroEjemplares(Integer nroEjemplares) {
        this.nroEjemplares = nroEjemplares;
    }
    
}
