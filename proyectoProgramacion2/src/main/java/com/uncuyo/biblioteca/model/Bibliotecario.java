package com.uncuyo.biblioteca.model;

public class Bibliotecario extends Persona {

    private Long id;
    protected Integer legajo;
    private String fechaNacimiento;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}
