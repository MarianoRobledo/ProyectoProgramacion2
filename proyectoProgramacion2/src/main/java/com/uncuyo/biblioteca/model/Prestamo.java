package com.uncuyo.biblioteca.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;

public class Prestamo {
    private Long id;

    @NotNull(message = "Ejemplar requerido")
    @Min(value = 1, message = "Ejemplar inválido")
    private Long ejemplarId;

    @NotNull(message = "Cliente requerido")
    @Min(value = 1, message = "Cliente inválido")
    private Long clienteId;

    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Fecha inicio debe tener formato dd-MM-yyyy")
    private String fechaInicio;

    @Pattern(regexp = "^$|^\\d{2}-\\d{2}-\\d{4}$", message = "Fecha devolución debe tener formato dd-MM-yyyy")
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
