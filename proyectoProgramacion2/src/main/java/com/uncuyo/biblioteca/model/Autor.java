package com.uncuyo.biblioteca.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Autor extends Persona{
    private Long id;

    @NotBlank(message = "El nombre del autor es obligatorio")
    @Size(max = 200, message = "Nombre del autor demasiado largo")
    private String nombre;

    // Fecha en formato ISO dd-MM-yyyy
    @Size(max = 20, message = "Fecha inválida")
    private String fechaDeFallecimiento;

    @Size(max = 100, message = "Nacionalidad demasiado larga")
    private String nacionalidad;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getFechaDeFallecimiento() { return fechaDeFallecimiento; }
    public void setFechaDeFallecimiento(String fechaDeFallecimiento) { this.fechaDeFallecimiento = fechaDeFallecimiento; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
}
