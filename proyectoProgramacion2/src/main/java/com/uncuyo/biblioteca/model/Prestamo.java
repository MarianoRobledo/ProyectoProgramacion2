package com.uncuyo.biblioteca.model;

public class Prestamo {
    private Long id;
    private Long ejemplarId;
    private Long clienteId;
    private String fechaInicio;
    private String fechaDevolucion;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEjemplarId() { return ejemplarId; }
    public void setEjemplarId(Long ejemplarId) { this.ejemplarId = ejemplarId; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }
    public String getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(String fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
}
