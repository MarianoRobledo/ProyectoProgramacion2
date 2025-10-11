package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.abm.IABMLibro;
import com.uncuyo.biblioteca.model.Libro;
import com.uncuyo.biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService implements IABMLibro {
    private final LibroRepository repo;

    public LibroService(LibroRepository repo) { this.repo = repo; }

    public List<Libro> list() { return repo.findAll(); }
    public Libro get(Long id) { return repo.findById(id); }
    public Libro save(Libro l) { return repo.save(l); }
    public void delete(Long id) { repo.deleteById(id); }

    @Override
    public Libro agregarLibro(Libro l) { return save(l); }

    @Override
    public Libro modificarLibro(Libro l) { return save(l); }

    @Override
    public void eliminarLibro(Long id) { delete(id); }

    @Override
    public List<Libro> consultarLibros() { return list(); }
}
