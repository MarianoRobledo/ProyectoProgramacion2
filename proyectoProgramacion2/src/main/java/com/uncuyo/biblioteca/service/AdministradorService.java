package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.abm.IABMAdministrador;
import com.uncuyo.biblioteca.abm.IABMBibliotecario;
import com.uncuyo.biblioteca.model.Administrador;
import com.uncuyo.biblioteca.model.Autor;
import com.uncuyo.biblioteca.model.Biblioteca;
import com.uncuyo.biblioteca.model.Bibliotecario;
import com.uncuyo.biblioteca.model.Cliente;
import com.uncuyo.biblioteca.model.Editorial;
import com.uncuyo.biblioteca.model.Ejemplar;
import com.uncuyo.biblioteca.model.Libro;
import com.uncuyo.biblioteca.model.Prestamo;
import com.uncuyo.biblioteca.repository.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.uncuyo.biblioteca.exception.DuplicateResourceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdministradorService implements IABMAdministrador, IABMBibliotecario {

    private final AdministradorRepository administradorRepo;
    private final AutorRepository autorRepo;
    private final BibliotecarioRepository bibliotecarioRepo;
    private final ClienteRepository clienteRepo;
    private final EditorialRepository editorialRepo;
    private final EjemplarRepository ejemplarRepo;
    private final LibroRepository libroRepo;
    private final PrestamoRepository prestamoRepo;
    private final BibliotecaRepository bibliotecaRepo;

    public AdministradorService(AdministradorRepository administradorRepo, AutorRepository autorRepo, BibliotecarioRepository bibliotecarioRepo, ClienteRepository clienteRepo, EditorialRepository editorialRepo, EjemplarRepository ejemplarRepo, LibroRepository libroRepo, PrestamoRepository prestamoRepo, BibliotecaRepository blibliotecaRepo) {
        this.administradorRepo = administradorRepo;
        this.autorRepo = autorRepo;
        this.bibliotecarioRepo = bibliotecarioRepo;
        this.clienteRepo = clienteRepo;
        this.editorialRepo = editorialRepo;
        this.ejemplarRepo = ejemplarRepo;
        this.libroRepo = libroRepo;
        this.prestamoRepo = prestamoRepo;
        this.bibliotecaRepo = blibliotecaRepo;
    }

    @Override
    public Administrador agregar(Administrador a) {
        // prevent duplicate DNI for administrators
        Administrador existing = administradorRepo.findByDni(a.getDni());
        if (existing != null) throw new DuplicateResourceException("Ya existe un administrador con DNI " + a.getDni());
        return administradorRepo.save(a);
    }

    @Override
    public Administrador modificar(Administrador a) {
        return administradorRepo.save(a);
    }

    @Override
    public void eliminarAdministrador(Long id) {
        administradorRepo.deleteById(id);
    }

    @Override
    public List<Administrador> consultarAdministradores() {
        return administradorRepo.findAll();
    }
    
    @Override
    public Administrador consultarAdministrador(Integer dni) {
        return administradorRepo.findByDni(dni);
    }

    @Override
    public Autor agregar(Autor a) {
        return autorRepo.save(a);
    }

    @Override
    public Autor modificar(Autor a) {
        return autorRepo.save(a);
    }

    @Override
    public void eliminarAutor(Long id) {
        autorRepo.deleteById(id);
    }

    @Override
    public List<Autor> consultarAutores() {
        return autorRepo.findAll();
    }
    
    @Override
    public Autor consultarAutor(Long id) {
        return autorRepo.findById(id);
    }

    @Override
    public Bibliotecario agregar(Bibliotecario b) {
        Bibliotecario existing = bibliotecarioRepo.findByDni(b.getDni());
        if (existing != null && (b.getId() == null || !existing.getId().equals(b.getId())))
            throw new DuplicateResourceException("Ya existe un bibliotecario con DNI " + b.getDni());
        return bibliotecarioRepo.save(b);
    }

    @Override
    public Bibliotecario modificar(Bibliotecario b) {
        return bibliotecarioRepo.save(b);
    }

    @Override
    public void eliminarBibliotecario(Long id) {
        bibliotecarioRepo.deleteById(id);
    }

    @Override
    public List<Bibliotecario> consultarBibliotecarios() {
        return bibliotecarioRepo.findAll();
    }
    
    @Override
    public Bibliotecario consultarBibliotecario(Integer id) {
        return bibliotecarioRepo.findByDni(id);
    }

    @Override
    public Cliente agregar(Cliente c) {
        Cliente existingByDni = clienteRepo.findByDni(c.getDni());
        if (existingByDni != null && (c.getId() == null || !existingByDni.getId().equals(c.getId())))
            throw new DuplicateResourceException("Ya existe un cliente con DNI " + c.getDni());
        Cliente existingByLegajo = clienteRepo.findByLegajo(c.getLegajo());
        if (existingByLegajo != null && (c.getId() == null || !existingByLegajo.getId().equals(c.getId())))
            throw new DuplicateResourceException("Ya existe un cliente con legajo " + c.getLegajo());
        Cliente existingByEmail = clienteRepo.findByEmail(c.getEmail());
        if (existingByEmail != null && (c.getId() == null || !existingByEmail.getId().equals(c.getId())))
            throw new DuplicateResourceException("Ya existe un cliente con email " + c.getEmail());
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
    public Editorial agregar(Editorial e) {
        return editorialRepo.save(e);
    }

    @Override
    public Editorial modificar(Editorial e) {
        return editorialRepo.save(e);
    }

    @Override
    public void eliminarEditorial(Long id) {
    }

    @Override
    public List<Editorial> consultarEditoriales() {
        return editorialRepo.findAll();
    }

    @Override
    public Editorial consultarEditorial(Long id) {
        return editorialRepo.findById(id);
    }
    
    @Override
    public Ejemplar agregar(Ejemplar e) {
        return ejemplarRepo.save(e);
    }

    @Override
    public Ejemplar modificar(Ejemplar e) {
        return ejemplarRepo.save(e);
    }

    @Override
    public void eliminarEjemplar(Long id) {
        ejemplarRepo.deleteById(id);
    }

    @Override
    public List<Ejemplar> consultarEjemplares() {
        return ejemplarRepo.findAll();
    }
    
    @Override
    public Ejemplar consultarEjemplar(Long id) {
        return ejemplarRepo.findById(id);
    }


    @Override
    public Libro agregar(Libro l) {
        // prevent duplicate ISBN
        if (l.getIsbn() != null) {
            Libro exists = libroRepo.findByIsbn(l.getIsbn());
            if (exists != null && (l.getId() == null || !exists.getId().equals(l.getId()))) {
                throw new DuplicateResourceException("Ya existe un libro con ISBN " + l.getIsbn());
            }
        }
        return libroRepo.save(l);
    }

    @Override
    public Libro modificar(Libro l) {
        return libroRepo.save(l);
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepo.deleteById(id);
    }

    @Override
    public List<Libro> consultarLibros() {
        return libroRepo.findAll();
    }
    
    public List<Libro> consultarLibrosAll() {
        return libroRepo.findAllIncludeInvisible();
    }
    
    @Override
    public Libro consultarLibro(Long id) {
        return libroRepo.findById(id);
    }

    @Override
    public Prestamo agregar(Prestamo p) {
        Prestamo saved = prestamoRepo.save(p);
        try {
            Cliente c = clienteRepo.findById(saved.getClienteId());
            if (c != null) {
                Integer curr = c.getReservedBooks() == null ? 0 : c.getReservedBooks();
                c.setReservedBooks(curr + 1);
                clienteRepo.save(c);
            }
        } catch (Exception ignored) {}
        return saved;
    }

    @Override
    public Prestamo modificar(Prestamo p) {
        // If fechaDevolucion is being set/modified, validate it is not before fechaInicio
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if (p.getFechaDevolucion() != null && !p.getFechaDevolucion().isBlank()) {
            // need the inicio date: prefer the incoming one, otherwise fetch existing record
            String inicioStr = p.getFechaInicio();
            if (inicioStr == null || inicioStr.isBlank()) {
                if (p.getId() == null) {
                    throw new IllegalStateException("No se proporcionó la fecha de inicio ni el id del préstamo");
                }
                Prestamo existing = prestamoRepo.findById(p.getId());
                if (existing == null) {
                    throw new IllegalStateException("Préstamo no encontrado");
                }
                inicioStr = existing.getFechaInicio();
            }
            LocalDate inicio;
            LocalDate devolucion;
            try {
                inicio = LocalDate.parse(inicioStr, fmt);
            } catch (Exception ex) {
                throw new IllegalStateException("Formato de fecha de inicio inválido");
            }
            try {
                devolucion = LocalDate.parse(p.getFechaDevolucion(), fmt);
            } catch (Exception ex) {
                throw new IllegalStateException("Formato de fecha de devolución inválido");
            }
            if (devolucion.isBefore(inicio)) {
                throw new IllegalArgumentException("La fecha de devolución no puede ser anterior a la fecha de inicio del préstamo");
            }
        }
        // detect if we are closing the loan now (fechaDevolucion was empty before and now set)
        boolean closingNow = false;
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

    public void closeLoan(Long id) {
        Prestamo p = prestamoRepo.findById(id);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // parse fechaInicio and ensure devolución (today) is not before inicio
        LocalDate inicio;
        try {
            inicio = LocalDate.parse(p.getFechaInicio(), fmt);
        } catch (Exception ex) {
            throw new IllegalStateException("Formato de fecha de inicio inválido");
        }
        LocalDate hoy = LocalDate.now();
        if (hoy.isBefore(inicio)) {
            throw new IllegalArgumentException("La fecha de devolución no puede ser anterior a la fecha de inicio del préstamo");
        }
        p.setFechaDevolucion(hoy.format(fmt));
        prestamoRepo.save(p);
    }
    
    public Biblioteca agregar(Biblioteca b) {
        return bibliotecaRepo.save(b);
    }

    public List<Biblioteca> consultarBibliotecas() {
        return bibliotecaRepo.findAll();
    }

    public Biblioteca consultarBiblioteca(Long id) {
        return bibliotecaRepo.findById(id);
    }    

    public void eliminarBiblioteca(Long id) {
        bibliotecaRepo.deleteById(id);
    }

    

    

    
    

    
    
}
