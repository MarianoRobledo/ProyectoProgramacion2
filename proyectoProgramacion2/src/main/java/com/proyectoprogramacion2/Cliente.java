package com.proyectoprogramacion2;

public class Cliente {
    private int dni;
    private int cantidadDeLibros;

    public Cliente() {}

    public Cliente(int dni, int cantidadDeLibros) {
        this.dni = dni;
        this.cantidadDeLibros = cantidadDeLibros;
    }

    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public int getCantidadDeLibros() { 
        return this.cantidadDeLibros; 
    }
    public int setCantidadDeLibros(int cantidadDeLibros) { 
        this.cantidadDeLibros = cantidadDeLibros; 
    }

}
