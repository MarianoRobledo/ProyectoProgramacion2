package com.uncuyo.biblioteca.abm;

import com.uncuyo.biblioteca.model.Cliente;
import com.uncuyo.biblioteca.model.Prestamo;
import java.util.List;

public interface IABMBibliotecario {
        
    Cliente agregar(Cliente c);
    Cliente modificar(Cliente c);
    void eliminarCliente(Long id);
    List<Cliente> consultarClientes();
    Cliente consultarCliente(Integer id);
    
    Prestamo agregar(Prestamo p);
    Prestamo modificar(Prestamo p);
    void eliminarPrestamo(Long id);
    List<Prestamo> consultarPrestamos();
    Prestamo consultarPrestamo(Long id);
}
