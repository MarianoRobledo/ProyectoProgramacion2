package com.uncuyo.biblioteca.abm;

import com.uncuyo.biblioteca.model.Cliente;
import java.util.List;

public interface IABMCliente {
    Cliente agregarCliente(Cliente c);
    Cliente modificarCliente(Cliente c);
    void eliminarCliente(Long id);
    List<Cliente> consultarClientes();
}
