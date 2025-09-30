package modelo;

import java.time.LocalDate;

public class Prestamo {
    private Ejemplar ejemplar;
    private Cliente cliente;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucion;

    public Prestamo() {}

    public Prestamo(Ejemplar ejemplar, Cliente cliente, LocalDate fechaInicio, LocalDate fechaDevolucion) {
        this.ejemplar = ejemplar;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Ejemplar getEjemplar() { return ejemplar; }
    public void setEjemplar(Ejemplar ejemplar) { this.ejemplar = ejemplar; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    @Override
    public String toString() {
        return "Prestamo{" +
                "ejemplar=" + ejemplar +
                ", cliente=" + cliente +
                ", fechaInicio=" + fechaInicio +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
