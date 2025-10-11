package com.uncuyo.biblioteca.model;

public class Autor {
    private Long id;
    private String nombre;
    private String fechaDeNacimiento;
    private String fechaDeFallecimiento;
    private String nacionalidad;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getFechaDeNacimiento() { return fechaDeNacimiento; }
    public void setFechaDeNacimiento(String fechaDeNacimiento) { this.fechaDeNacimiento = fechaDeNacimiento; }
    public String getFechaDeFallecimiento() { return fechaDeFallecimiento; }
    public void setFechaDeFallecimiento(String fechaDeFallecimiento) { this.fechaDeFallecimiento = fechaDeFallecimiento; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
}
