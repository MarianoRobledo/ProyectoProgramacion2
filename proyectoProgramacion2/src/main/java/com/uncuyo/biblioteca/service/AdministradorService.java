package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.abm.IABMAdministrador;
import com.uncuyo.biblioteca.abm.IABMEjemplar;
import com.uncuyo.biblioteca.model.Administrador;
import com.uncuyo.biblioteca.model.Ejemplar;
import com.uncuyo.biblioteca.repository.AdministradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService implements IABMAdministrador, IABMEjemplar {
    private final AdministradorRepository repo;
    private final EjemplarService ejemplarService;

    public AdministradorService(AdministradorRepository repo, EjemplarService ejemplarService) { this.repo = repo; this.ejemplarService = ejemplarService; }

    @Override
    public Administrador agregarAdministrador(Administrador a) { return repo.save(a); }

    @Override
    public Administrador modificarAdministrador(Administrador a) { return repo.save(a); }

    @Override
    public void eliminarAdministrador(Long id) { repo.deleteById(id); }

    @Override
    public List<Administrador> consultarAdministradores() { return repo.findAll(); }

    // lookup by ID
    public Administrador get(Long id) { return repo.findById(id); }

    // lookup by DNI
    public Administrador findByDni(Integer dni) { return repo.findByDni(dni); }

    @Override
    public Ejemplar agregarEjemplar(Ejemplar e) { return ejemplarService.agregarEjemplar(e); }

    @Override
    public Ejemplar modificarEjemplar(Ejemplar e) { return ejemplarService.modificarEjemplar(e); }

    @Override
    public void eliminarEjemplar(Long id) { ejemplarService.eliminarEjemplar(id); }

    @Override
    public List<Ejemplar> consultarEjemplares() { return ejemplarService.consultarEjemplares(); }
}
