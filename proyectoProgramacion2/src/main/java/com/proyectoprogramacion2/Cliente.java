package com.proyectoprogramacion2;

public class Cliente {
    private int dni;
    private int cantidadDeLibros;

    public Cliente() {}

    public Cliente(int dni, int cantidadDeLibros) {
        this.dni = dni;
        this.cantidadDeLibros = cantidadDeLibros;
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
