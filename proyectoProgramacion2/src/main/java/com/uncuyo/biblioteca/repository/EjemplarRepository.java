package com.uncuyo.biblioteca.repository;

import com.uncuyo.biblioteca.model.Ejemplar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EjemplarRepository {
    private final JdbcTemplate jdbc;

    public EjemplarRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    private RowMapper<Ejemplar> mapper = (rs, rowNum) -> {
        Ejemplar e = new Ejemplar();
        e.setId(rs.getLong("id"));
        e.setLibroId(rs.getLong("libro_id"));
        return e;
    };

    public List<Ejemplar> findAll() { return jdbc.query("SELECT * FROM ejemplar", mapper); }

    public Ejemplar findById(Long id) { return jdbc.queryForObject("SELECT * FROM ejemplar WHERE id = ?", mapper, id); }

    public Ejemplar save(Ejemplar e) {
        if (e.getId() == null) {
            jdbc.update("INSERT INTO ejemplar(libro_id) VALUES(?)", e.getLibroId());
            Long id = jdbc.queryForObject("SELECT last_insert_rowid()", Long.class);
            e.setId(id);
            return e;
        } else {
            jdbc.update("UPDATE ejemplar SET libro_id=? WHERE id=?", e.getLibroId(), e.getId());
            return e;
        }
    }

    public void deleteById(Long id) { jdbc.update("DELETE FROM ejemplar WHERE id = ?", id); }
}
