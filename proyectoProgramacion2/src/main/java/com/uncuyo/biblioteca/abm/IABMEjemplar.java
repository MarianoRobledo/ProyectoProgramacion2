package com.uncuyo.biblioteca.abm;

import com.uncuyo.biblioteca.model.Ejemplar;
import java.util.List;

public interface IABMEjemplar {
    Ejemplar agregarEjemplar(Ejemplar e);
    Ejemplar modificarEjemplar(Ejemplar e);
    void eliminarEjemplar(Long id);
    List<Ejemplar> consultarEjemplares();
    Ejemplar consultarEjemplarer();
}
