package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.model.Libro;
import com.uncuyo.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository repo;

    public List<Libro> listAll() { return repo.findAll(); }
    public Libro get(int id) { return repo.findById(id); }
    public int save(Libro libro) { return repo.save(libro); }
    public void delete(int id) { repo.delete(id); }
}
