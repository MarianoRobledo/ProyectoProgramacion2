/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoprogramacion2;

import java.util.Date;

/**
 *
 * @author mariano
 */
public class Administrador extends  Bibliotecario{

    public Administrador() {
    }

    
    public Administrador(int dni, String nombre, String apellido, Date fechaDeNacimiento, int telefono, String email) {
        super(dni, nombre, apellido, fechaDeNacimiento, telefono, email);
    }
    
    
    
}
