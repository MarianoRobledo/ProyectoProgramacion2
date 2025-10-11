package com.uncuyo.biblioteca.abm;

import com.uncuyo.biblioteca.model.Bibliotecario;
import java.util.List;

public interface IABMBibliotecario {
    Bibliotecario agregarBibliotecario(Bibliotecario b);
    Bibliotecario modificarBibliotecario(Bibliotecario b);
    void eliminarBibliotecario(Long id);
    List<Bibliotecario> consultarBibliotecarios();
}
