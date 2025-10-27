package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.abm.IABMBibliotecario;
import com.uncuyo.biblioteca.model.Cliente;
import com.uncuyo.biblioteca.model.Prestamo;
import com.uncuyo.biblioteca.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.uncuyo.biblioteca.exception.DuplicateResourceException;

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
        Cliente existingByDni = clienteRepo.findByDni(c.getDni());
        if (existingByDni != null && (c.getId() == null || !existingByDni.getId().equals(c.getId())))
            throw new DuplicateResourceException("Ya existe un cliente con DNI " + c.getDni());
        Cliente existingByLegajo = clienteRepo.findByLegajo(c.getLegajo());
        if (existingByLegajo != null && (c.getId() == null || !existingByLegajo.getId().equals(c.getId())))
            throw new DuplicateResourceException("Ya existe un cliente con legajo " + c.getLegajo());
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
    public Prestamo agregar(Prestamo p) {
        Prestamo saved = prestamoRepo.save(p);
        // Increment reservedBooks only if the loan is active (no fechaDevolucion)
        if (saved.getFechaDevolucion() == null || saved.getFechaDevolucion().isBlank()) {
            try {
                Cliente c = clienteRepo.findById(saved.getClienteId());
                if (c != null) {
                    Integer curr = c.getReservedBooks() == null ? 0 : c.getReservedBooks();
                    c.setReservedBooks(curr + 1);
                    clienteRepo.save(c);
                }
            } catch (Exception ignored) {}
        }
        return saved;
    }

    @Override
    public Prestamo modificar(Prestamo p) {
        boolean closingNow = false;
        // If fechaDevolucion is provided and previously was empty, we consider the loan finished
        if (p.getFechaDevolucion() != null && !p.getFechaDevolucion().isBlank() && p.getId() != null) {
            try {
                Prestamo existing = prestamoRepo.findById(p.getId());
                if (existing != null) {
                    String oldDev = existing.getFechaDevolucion();
                    if (oldDev == null || oldDev.isBlank()) closingNow = true;
                }
            } catch (Exception ignored) { closingNow = false; }
        }

        Prestamo saved = prestamoRepo.save(p);

        if (closingNow) {
            try {
                Cliente c = clienteRepo.findById(saved.getClienteId());
                if (c != null) {
                    Integer curr = c.getReservedBooks() == null ? 0 : c.getReservedBooks();
                    c.setReservedBooks(Math.max(0, curr - 1));
                    clienteRepo.save(c);
                }
            } catch (Exception ignored) {}
        }
        return saved;
    }

    @Override
    @Transactional
    public void eliminarPrestamo(Long id) {
        Prestamo p = null;
        try { p = prestamoRepo.findById(id); } catch (Exception ignored) { p = null; }
        if (p != null) {
            prestamoRepo.deleteById(id);
            try {
                Cliente c = clienteRepo.findById(p.getClienteId());
                if (c != null) {
                    Integer curr = c.getReservedBooks() == null ? 0 : c.getReservedBooks();
                    c.setReservedBooks(Math.max(0, curr - 1));
                    clienteRepo.save(c);
                }
            } catch (Exception ignored) {}
        }
    }

    @Override
    public List<Prestamo> consultarPrestamos() {
        return prestamoRepo.findAll();
    }
    
    @Override
    public Prestamo consultarPrestamo(Long id) {
        return prestamoRepo.findById(id);
    }
    
    

}
