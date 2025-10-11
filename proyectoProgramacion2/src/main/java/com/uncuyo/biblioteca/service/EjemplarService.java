package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.abm.IABMEjemplar;
import com.uncuyo.biblioteca.model.Ejemplar;
import com.uncuyo.biblioteca.repository.EjemplarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjemplarService implements IABMEjemplar {
    private final EjemplarRepository repo;

    public EjemplarService(EjemplarRepository repo) { this.repo = repo; }

    public List<Ejemplar> list() { return repo.findAll(); }
    public Ejemplar get(Long id) { return repo.findById(id); }
    public Ejemplar save(Ejemplar e) { return repo.save(e); }
    public void delete(Long id) { repo.deleteById(id); }

    @Override
    public Ejemplar agregarEjemplar(Ejemplar e) { return save(e); }

    @Override
    public Ejemplar modificarEjemplar(Ejemplar e) { return save(e); }

    @Override
    public void eliminarEjemplar(Long id) { delete(id); }

    @Override
    public List<Ejemplar> consultarEjemplares() { return list(); }
}
