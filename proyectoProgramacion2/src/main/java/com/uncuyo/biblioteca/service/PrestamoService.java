package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.abm.IABMPrestamo;
import com.uncuyo.biblioteca.model.Prestamo;
import com.uncuyo.biblioteca.repository.PrestamoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoService implements IABMPrestamo {
    private final PrestamoRepository repo;
    private final JdbcTemplate jdbc;

    public PrestamoService(PrestamoRepository repo, JdbcTemplate jdbc) { this.repo = repo; this.jdbc = jdbc; }

    public List<Prestamo> list() { return repo.findAll(); }
    public Prestamo get(Long id) { return repo.findById(id); }

    // Create a loan: mark ejemplar as unavailable and insert prestamo
    public Prestamo create(Prestamo p) {
        // Ensure ejemplar exists and not already loaned
        Integer count = jdbc.queryForObject("SELECT COUNT(*) FROM prestamo WHERE ejemplar_id = ? AND fechaDevolucion IS NULL", Integer.class, p.getEjemplarId());
        if (count != null && count > 0) {
            throw new IllegalStateException("Ejemplar already loaned");
        }
        p.setFechaInicio(LocalDate.now().toString());
        repo.save(p);
        return p;
    }

    public void closeLoan(Long id) {
        Prestamo p = repo.findById(id);
        p.setFechaDevolucion(LocalDate.now().toString());
        repo.save(p);
    }

    @Override
    public Prestamo agregarPrestamo(Prestamo p) { return create(p); }

    @Override
    public Prestamo modificarPrestamo(Prestamo p) { return repo.save(p); }

    @Override
    public void eliminarPrestamo(Long id) { repo.deleteById(id); }

    @Override
    public List<Prestamo> consultarPrestamos() { return repo.findAll(); }
}

