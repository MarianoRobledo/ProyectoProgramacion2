
package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.abm.IABMAutor;
import com.uncuyo.biblioteca.model.Autor;
import com.uncuyo.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService implements IABMAutor {
    private final AutorRepository repo;

    public AutorService(AutorRepository repo) { this.repo = repo; }

    public List<Autor> list() { return repo.findAll(); }
    public Autor get(Long id) { return repo.findById(id); }
    public Autor save(Autor a) { return repo.save(a); }
    public void delete(Long id) { repo.deleteById(id); }

    @Override
    public Autor agregarAutor(Autor a) { return save(a); }

    @Override
    public Autor modificarAutor(Autor a) { return save(a); }

    @Override
    public void eliminarAutor(Long id) { delete(id); }

    @Override
    public List<Autor> consultarAutores() { return list(); }
}
