package com.uncuyo.biblioteca.abm;

import com.uncuyo.biblioteca.model.Libro;
import java.util.List;

public interface IABMLibro {
    Libro agregarLibro(Libro l);
    Libro modificarLibro(Libro l);
    void eliminarLibro(Long id);
    List<Libro> consultarLibros();
}
