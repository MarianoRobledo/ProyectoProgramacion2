package modelo;

import java.util.Date;

public class Cliente extends Persona{
    private int dni;
    private int cantidadDeLibros;

    public Cliente() {}
    
    
    public Cliente(String nombre, String apellido, Date fechaDeNacimiento, int telefono, String email,int dni, int cantidadDeLibros) {
        super(nombre, apellido, fechaDeNacimiento, telefono, email);
        this.dni = dni;
        this.cantidadDeLibros = cantidadDeLibros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public int getDni() { 
        return this.dni; 
    }
    public void setDni(int dni) { 
        this.dni = dni;
    }

    public int getCantidadDeLibros() { 
        return this.cantidadDeLibros; 
    }
    public void setCantidadDeLibros(int cantidadDeLibros) { 
        this.cantidadDeLibros = cantidadDeLibros; 
    }

}
