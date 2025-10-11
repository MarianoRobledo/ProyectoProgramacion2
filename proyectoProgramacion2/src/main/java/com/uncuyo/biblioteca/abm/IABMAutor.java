package com.uncuyo.biblioteca.abm;

import com.uncuyo.biblioteca.model.Autor;
import java.util.List;

public interface IABMAutor {
    Autor agregarAutor(Autor a);
    Autor modificarAutor(Autor a);
    void eliminarAutor(Long id);
    List<Autor> consultarAutores();
}
