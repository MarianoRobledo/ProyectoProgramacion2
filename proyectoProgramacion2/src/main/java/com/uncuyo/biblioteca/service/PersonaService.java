package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.model.Persona;
import com.uncuyo.biblioteca.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository repo;

    public Persona findByEmail(String email) { return repo.findByEmail(email); }
    public Persona findById(int id) { return repo.findById(id); }
    public List<Persona> findAll() { return repo.findAll(); }
}
