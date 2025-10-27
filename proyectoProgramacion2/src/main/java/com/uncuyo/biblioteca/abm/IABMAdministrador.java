package com.uncuyo.biblioteca.abm;

import com.uncuyo.biblioteca.model.Administrador;
import com.uncuyo.biblioteca.model.Autor;
import com.uncuyo.biblioteca.model.Bibliotecario;
import com.uncuyo.biblioteca.model.Editorial;
import com.uncuyo.biblioteca.model.Ejemplar;
import com.uncuyo.biblioteca.model.Libro;
import java.util.List;

public interface IABMAdministrador {
    
    Administrador agregar(Administrador a);
    Administrador modificar(Administrador a);
    void eliminarAdministrador(Long id);
    List<Administrador> consultarAdministradores();
    Administrador consultarAdministrador(Integer dni);
    
    Autor agregar(Autor a);
    Autor modificar(Autor a);
    void eliminarAutor(Long id);
    List<Autor> consultarAutores();
    Autor consultarAutor(Long id);
    
    Bibliotecario agregar(Bibliotecario b);
    Bibliotecario modificar(Bibliotecario b);
    void eliminarBibliotecario(Long id);
    List<Bibliotecario> consultarBibliotecarios();
    Bibliotecario consultarBibliotecario(Integer id);
    
    Editorial agregar(Editorial e);
    Editorial modificar(Editorial e);
    void eliminarEditorial(Long id);
    List<Editorial> consultarEditoriales();
    Editorial consultarEditorial(Long id);
    
    Ejemplar agregar(Ejemplar e);
    Ejemplar modificar(Ejemplar e);
    void eliminarEjemplar(Long id);
    List<Ejemplar> consultarEjemplares();
    Ejemplar consultarEjemplar(Long id);
    
    Libro agregar(Libro l);
    Libro modificar(Libro l);
    void eliminarLibro(Long id);
    List<Libro> consultarLibros();
    Libro consultarLibro(Long id);
    
}
