package com.uncuyo.biblioteca.model;

public class Prestamo {
    private Integer id;
    private Integer ejemplarId;
    private Integer clienteId;
    private String fechaInicio;
    private String fechaDevolucion;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getEjemplarId() { return ejemplarId; }
    public void setEjemplarId(Integer ejemplarId) { this.ejemplarId = ejemplarId; }
    public Integer getClienteId() { return clienteId; }
    public void setClienteId(Integer clienteId) { this.clienteId = clienteId; }
    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }
    public String getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(String fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
}
