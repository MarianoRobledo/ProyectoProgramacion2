package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.abm.IABMAdministrador;
import com.uncuyo.biblioteca.abm.IABMBibliotecario;
import com.uncuyo.biblioteca.model.Administrador;
import com.uncuyo.biblioteca.model.Autor;
import com.uncuyo.biblioteca.model.Biblioteca;
import com.uncuyo.biblioteca.model.Bibliotecario;
import com.uncuyo.biblioteca.model.Cliente;
import com.uncuyo.biblioteca.model.Editorial;
import com.uncuyo.biblioteca.model.Ejemplar;
import com.uncuyo.biblioteca.model.Libro;
import com.uncuyo.biblioteca.model.Prestamo;
import com.uncuyo.biblioteca.repository.*;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService implements IABMAdministrador, IABMBibliotecario {

    private final AdministradorRepository administradorRepo;
    private final AutorRepository autorRepo;
    private final BibliotecarioRepository bibliotecarioRepo;
    private final ClienteRepository clienteRepo;
    private final EditorialRepository editorialRepo;
    private final EjemplarRepository ejemplarRepo;
    private final LibroRepository libroRepo;
    private final PrestamoRepository prestamoRepo;
    private final BibliotecaRepository bibliotecaRepo;

    public AdministradorService(AdministradorRepository administradorRepo, AutorRepository autorRepo, BibliotecarioRepository bibliotecarioRepo, ClienteRepository clienteRepo, EditorialRepository editorialRepo, EjemplarRepository ejemplarRepo, LibroRepository libroRepo, PrestamoRepository prestamoRepo, BibliotecaRepository blibliotecaRepo) {
        this.administradorRepo = administradorRepo;
        this.autorRepo = autorRepo;
        this.bibliotecarioRepo = bibliotecarioRepo;
        this.clienteRepo = clienteRepo;
        this.editorialRepo = editorialRepo;
        this.ejemplarRepo = ejemplarRepo;
        this.libroRepo = libroRepo;
        this.prestamoRepo = prestamoRepo;
        this.bibliotecaRepo = blibliotecaRepo;
    }

    @Override
    public Administrador agregar(Administrador a) {
        return administradorRepo.save(a);
    }

    @Override
    public Administrador modificar(Administrador a) {
        return administradorRepo.save(a);
    }

    @Override
    public void eliminarAdministrador(Long id) {
        administradorRepo.deleteById(id);
    }

    @Override
    public List<Administrador> consultarAdministradores() {
        return administradorRepo.findAll();
    }
    
    @Override
    public Administrador consultarAdministrador(Integer dni) {
        return administradorRepo.findByDni(dni);
    }

    @Override
    public Autor agregar(Autor a) {
        return autorRepo.save(a);
    }

    @Override
    public Autor modificar(Autor a) {
        return autorRepo.save(a);
    }

    @Override
    public void eliminarAutor(Long id) {
        autorRepo.deleteById(id);
    }

    @Override
    public List<Autor> consultarAutores() {
        return autorRepo.findAll();
    }
    
    @Override
    public Autor consultarAutor(Long id) {
        return autorRepo.findById(id);
    }

    @Override
    public Bibliotecario agregar(Bibliotecario b) {
        return bibliotecarioRepo.save(b);
    }

    @Override
    public Bibliotecario modificar(Bibliotecario b) {
        return bibliotecarioRepo.save(b);
    }

    @Override
    public void eliminarBibliotecario(Long id) {
        bibliotecarioRepo.deleteById(id);
    }

    @Override
    public List<Bibliotecario> consultarBibliotecarios() {
        return bibliotecarioRepo.findAll();
    }
    
    @Override
    public Bibliotecario consultarBibliotecario(Integer id) {
        return bibliotecarioRepo.findByDni(id);
    }

    @Override
    public Cliente agregar(Cliente c) {
        return clienteRepo.save(c);
    }

    @Override
    public Cliente modificar(Cliente c) {
        return clienteRepo.save(c);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public List<Cliente> consultarClientes() {
        return clienteRepo.findAll();
    }
    
    @Override
    public Cliente consultarCliente(Integer id) {
        return clienteRepo.findByDni(id);
    }


    @Override
    public Editorial agregar(Editorial e) {
        return editorialRepo.save(e);
    }

    @Override
    public Editorial modificar(Editorial e) {
        return editorialRepo.save(e);
    }

    @Override
    public void eliminarEditorial(Long id) {
    }

    @Override
    public List<Editorial> consultarEditoriales() {
        return editorialRepo.findAll();
    }

    @Override
    public Editorial consultarEditorial(Long id) {
        return editorialRepo.findById(id);
    }
    
    @Override
    public Ejemplar agregar(Ejemplar e) {
        return ejemplarRepo.save(e);
    }

    @Override
    public Ejemplar modificar(Ejemplar e) {
        return ejemplarRepo.save(e);
    }

    @Override
    public void eliminarEjemplar(Long id) {
        ejemplarRepo.deleteById(id);
    }

    @Override
    public List<Ejemplar> consultarEjemplares() {
        return ejemplarRepo.findAll();
    }
    
    @Override
    public Ejemplar consultarEjemplar(Long id) {
        return ejemplarRepo.findById(id);
    }


    @Override
    public Libro agregar(Libro l) {
        return libroRepo.save(l);
    }

    @Override
    public Libro modificar(Libro l) {
        return libroRepo.save(l);
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepo.deleteById(id);
    }

    @Override
    public List<Libro> consultarLibros() {
        return libroRepo.findAll();
    }
    
    @Override
    public Libro consultarLibro(Long id) {
        return libroRepo.findById(id);
    }

    @Override
    public Prestamo agregar(Prestamo p) {
        return prestamoRepo.save(p);
    }

    @Override
    public Prestamo modificar(Prestamo p) {
        return prestamoRepo.save(p);
    }

    @Override
    public void eliminarPrestamo(Long id) {
        prestamoRepo.deleteById(id);
    }

    @Override
    public List<Prestamo> consultarPrestamos() {
        return prestamoRepo.findAll();
    }
    
    @Override
    public Prestamo consultarPrestamo(Long id) {
        return prestamoRepo.findById(id);
    }

    public void closeLoan(Long id) {
        Prestamo p = prestamoRepo.findById(id);
        p.setFechaDevolucion(LocalDate.now().toString());
        prestamoRepo.save(p);
    }
    
    public Biblioteca agregar(Biblioteca b) {
        return bibliotecaRepo.save(b);
    }

    public List<Biblioteca> consultarBibliotecas() {
        return bibliotecaRepo.findAll();
    }

    public Biblioteca consultarBiblioteca(Long id) {
        return bibliotecaRepo.findById(id);
    }    

    public void eliminarBiblioteca(Long id) {
        bibliotecaRepo.deleteById(id);
    }

    

    

    
    

    
    
}
