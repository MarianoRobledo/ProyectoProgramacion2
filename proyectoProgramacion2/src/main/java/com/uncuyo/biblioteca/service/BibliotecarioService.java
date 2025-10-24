package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.abm.IABMBibliotecario;
import com.uncuyo.biblioteca.model.Bibliotecario;
import com.uncuyo.biblioteca.model.Cliente;
import com.uncuyo.biblioteca.model.Prestamo;
import com.uncuyo.biblioteca.repository.*;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecarioService implements IABMBibliotecario {

    private final ClienteRepository clienteRepo;
    private final PrestamoRepository prestamoRepo;

    public BibliotecarioService(ClienteRepository clienteRepo, PrestamoRepository prestamoRepo) {
        this.clienteRepo = clienteRepo;
        this.prestamoRepo = prestamoRepo;
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
    
    

}
