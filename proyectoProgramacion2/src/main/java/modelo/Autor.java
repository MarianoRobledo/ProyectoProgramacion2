package modelo;

import java.time.LocalDate;

public class Autor {
    private LocalDate fechaDeFallecimiento;
    private String nacionalidad;
    private String nombre;

    public Autor() {}

    public Autor(String nombre, LocalDate fechaDeFallecimiento, String nacionalidad) {
        this.nombre = nombre;
        this.fechaDeFallecimiento = fechaDeFallecimiento;
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaDeFallecimiento() { return fechaDeFallecimiento; }
    public void setFechaDeFallecimiento(LocalDate fechaDeFallecimiento) { this.fechaDeFallecimiento = fechaDeFallecimiento; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", fechaDeFallecimiento=" + fechaDeFallecimiento +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
