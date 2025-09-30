/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mariano-ubuntu
 */
public class Biblioteca {
    
    private String nombre;
    private String direccion;
    private int telefono;
    private String email;
    private Administrador administrador;
    private List<Cliente> Cliente;
    private List<Bibliotecario> biliotecarios;
    private List<Libro> libros;
    private List<Prestamo> Prestamos;

    public Biblioteca() {
    }

    public Biblioteca(String nombre, String direccion, int telefono, String email, Administrador administrador){
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.administrador = administrador;
        this.Cliente = new ArrayList<Cliente>();
        this.biliotecarios = new ArrayList<Bibliotecario>();
        this.libros = new ArrayList<Libro>();
        this.Prestamos = new ArrayList<Prestamo>();
    }

    public Biblioteca(String nombre, String direccion, int telefono, String email, Administrador administrador, List<Cliente> Cliente, List<Bibliotecario> biliotecarios, List<Libro> libros, List<Prestamo> Prestamos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.administrador = administrador;
        this.Cliente = Cliente;
        this.biliotecarios = biliotecarios;
        this.libros = libros;
        this.Prestamos = Prestamos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Cliente> getCliente() {
        return Cliente;
    }

    public void setCliente(List<Cliente> Cliente) {
        this.Cliente = Cliente;
    }

    public List<Bibliotecario> getBiliotecarios() {
        return biliotecarios;
    }

    public void setBiliotecarios(List<Bibliotecario> biliotecarios) {
        this.biliotecarios = biliotecarios;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Prestamo> getPrestamos() {
        return Prestamos;
    }

    public void setPrestamos(List<Prestamo> Prestamos) {
        this.Prestamos = Prestamos;
    }
    
    
    
    
    
}
