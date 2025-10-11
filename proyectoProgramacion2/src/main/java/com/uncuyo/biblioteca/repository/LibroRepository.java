package com.uncuyo.biblioteca.repository;

import com.uncuyo.biblioteca.model.Libro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/*import java.sql.ResultSet;
import java.sql.SQLException;*/
import java.util.List;

@Repository
public class LibroRepository {
    private final JdbcTemplate jdbc;

    public LibroRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    private RowMapper<Libro> mapper = (rs, rowNum) -> {
        Libro l = new Libro();
        l.setId(rs.getLong("id"));
        l.setIsbn(rs.getString("isbn"));
        l.setTitulo(rs.getString("titulo"));
        l.setEditorialId(rs.getLong("editorial_id"));
        l.setAnioPublicacion(rs.getInt("anioPublicacion"));
        l.setAutorId(rs.getLong("autor_id"));
        l.setDisponible(rs.getInt("disponible") == 1);
        return l;
    };

    public List<Libro> findAll() {
        return jdbc.query("SELECT * FROM libro", mapper);
    }

    public Libro findById(Long id) {
        return jdbc.queryForObject("SELECT * FROM libro WHERE id = ?", mapper, id);
    }

    public Libro save(Libro libro) {
        if (libro.getId() == null) {
        int disponibleInt = libro.getDisponible() == null ? 1 : (libro.getDisponible() ? 1 : 0);
        jdbc.update("INSERT INTO libro(isbn,titulo,editorial_id,anioPublicacion,autor_id,disponible) VALUES(?,?,?,?,?,?)",
            libro.getIsbn(), libro.getTitulo(), libro.getEditorialId(), libro.getAnioPublicacion(), libro.getAutorId(), disponibleInt);
            Long id = jdbc.queryForObject("SELECT last_insert_rowid()", Long.class);
            libro.setId(id);
            return libro;
        } else {
        int disponibleInt = libro.getDisponible() == null ? 1 : (libro.getDisponible() ? 1 : 0);
        jdbc.update("UPDATE libro SET isbn=?, titulo=?, editorial_id=?, anioPublicacion=?, autor_id=?, disponible=? WHERE id=?",
            libro.getIsbn(), libro.getTitulo(), libro.getEditorialId(), libro.getAnioPublicacion(), libro.getAutorId(), disponibleInt, libro.getId());
            return libro;
        }
    }

    public void deleteById(Long id) {
        jdbc.update("DELETE FROM libro WHERE id = ?", id);
    }
}
