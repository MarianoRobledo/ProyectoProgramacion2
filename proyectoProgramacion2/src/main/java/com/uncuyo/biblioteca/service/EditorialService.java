package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.abm.IABMEditorial;
import com.uncuyo.biblioteca.model.Editorial;
import com.uncuyo.biblioteca.repository.EditorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialService implements IABMEditorial {
    private final EditorialRepository repo;

    public EditorialService(EditorialRepository repo) { this.repo = repo; }

    public List<Editorial> list() { return repo.findAll(); }
    public Editorial get(Long id) { return repo.findById(id); }
    public Editorial save(Editorial e) { return repo.save(e); }
    public void delete(Long id) { repo.deleteById(id); }

    @Override
    public Editorial agregarEditorial(Editorial e) { return save(e); }

    @Override
    public Editorial modificarEditorial(Editorial e) { return save(e); }

    @Override
    public void eliminarEditorial(Long id) { delete(id); }

    @Override
    public List<Editorial> consultarEditoriales() { return list(); }
}
