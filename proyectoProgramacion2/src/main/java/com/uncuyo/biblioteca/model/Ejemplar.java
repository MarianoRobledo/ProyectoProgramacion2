package com.uncuyo.biblioteca.model;

public class Ejemplar {
    private Integer id;
    private Integer libroId;
    private Boolean disponible;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getLibroId() { return libroId; }
    public void setLibroId(Integer libroId) { this.libroId = libroId; }
    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }
}
