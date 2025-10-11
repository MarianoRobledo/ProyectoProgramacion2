package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.abm.IABMBibliotecario;
import com.uncuyo.biblioteca.model.Bibliotecario;
import com.uncuyo.biblioteca.repository.BibliotecarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecarioService implements IABMBibliotecario {
    private final BibliotecarioRepository repo;

    public BibliotecarioService(BibliotecarioRepository repo) { this.repo = repo; }

    @Override
    public Bibliotecario agregarBibliotecario(Bibliotecario b) { return repo.save(b); }

    @Override
    public Bibliotecario modificarBibliotecario(Bibliotecario b) { return repo.save(b); }

    @Override
    public void eliminarBibliotecario(Long id) { repo.deleteById(id); }

    @Override
    public List<Bibliotecario> consultarBibliotecarios() { return repo.findAll(); }

    // lookup by ID
    public Bibliotecario get(Long id) { return repo.findById(id); }

    // lookup by DNI
    public Bibliotecario findByDni(Integer dni) { return repo.findByDni(dni); }
}
