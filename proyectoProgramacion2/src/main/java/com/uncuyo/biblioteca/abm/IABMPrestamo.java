package com.uncuyo.biblioteca.abm;

import com.uncuyo.biblioteca.model.Prestamo;
import java.util.List;

public interface IABMPrestamo {
    Prestamo agregarPrestamo(Prestamo p);
    Prestamo modificarPrestamo(Prestamo p);
    void eliminarPrestamo(Long id);
    List<Prestamo> consultarPrestamos();
    Prestamo consultarPrestamo();
}
