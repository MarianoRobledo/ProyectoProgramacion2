package com.uncuyo.biblioteca.repository;

import com.uncuyo.biblioteca.model.Prestamo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrestamoRepository {
    private final JdbcTemplate jdbc;

    public PrestamoRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    private RowMapper<Prestamo> mapper = (rs, rowNum) -> {
        Prestamo p = new Prestamo();
        p.setId(rs.getLong("id"));
        p.setEjemplarId(rs.getLong("ejemplar_id"));
        p.setClienteId(rs.getLong("cliente_id"));
        p.setFechaInicio(rs.getString("fechaInicio"));
        p.setFechaDevolucion(rs.getString("fechaDevolucion"));
        return p;
    };

    public List<Prestamo> findAll() { return jdbc.query("SELECT * FROM prestamo", mapper); }

    public Prestamo findById(Long id) { return jdbc.queryForObject("SELECT * FROM prestamo WHERE id = ?", mapper, id); }

    public Prestamo save(Prestamo p) {
        if (p.getId() == null) {
            jdbc.update("INSERT INTO prestamo(ejemplar_id,cliente_id,fechaInicio,fechaDevolucion) VALUES(?,?,?,?)",
                    p.getEjemplarId(), p.getClienteId(), p.getFechaInicio(), p.getFechaDevolucion());
            Long id = jdbc.queryForObject("SELECT last_insert_rowid()", Long.class);
            p.setId(id);
            return p;
        } else {
            jdbc.update("UPDATE prestamo SET ejemplar_id=?, cliente_id=?, fechaInicio=?, fechaDevolucion=? WHERE id=?",
                    p.getEjemplarId(), p.getClienteId(), p.getFechaInicio(), p.getFechaDevolucion(), p.getId());
            return p;
        }
    }

    public void deleteById(Long id) { jdbc.update("DELETE FROM prestamo WHERE id = ?", id); }
}
