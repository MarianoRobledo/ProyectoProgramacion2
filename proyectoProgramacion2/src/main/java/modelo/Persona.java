/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author mariano
 */
public abstract class Persona {
    
    protected String nombre;
    protected String apellido;
    protected Date fechaDeNacimiento;
    protected int telefono;
    protected String email;

    public Persona() {
    }
    
    

    public Persona(String nombre, String apellido, Date fechaDeNacimiento, int telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.telefono = telefono;
        this.email = email;
    }
    
    
    
    
}
