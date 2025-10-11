package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.model.Biblioteca;
import com.uncuyo.biblioteca.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {
    private final BibliotecaRepository repo;

    public BibliotecaService(BibliotecaRepository repo) { this.repo = repo; }

    public List<Biblioteca> list() { return repo.findAll(); }
    public Biblioteca get(Long id) { return repo.findById(id); }
    public Biblioteca save(Biblioteca b) { return repo.save(b); }
    public void delete(Long id) { repo.deleteById(id); }
}
