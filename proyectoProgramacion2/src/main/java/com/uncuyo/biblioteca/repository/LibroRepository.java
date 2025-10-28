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
        try { l.setVisible(rs.getBoolean("visible")); } catch (Exception ex) { l.setVisible(Boolean.TRUE); }
        return l;
    };

    public List<Libro> findAll() {
        // only return visible books for regular listings
        return jdbc.query("SELECT * FROM libro WHERE visible = 1", mapper);
    }

    public List<Libro> findAllIncludeInvisible() {
        return jdbc.query("SELECT * FROM libro", mapper);
    }

    public Libro findById(Long id) {
        return jdbc.queryForObject("SELECT * FROM libro WHERE id = ?", mapper, id);
    }

    public Libro save(Libro libro) {
        if (libro.getId() == null) {
        int visibleInt = libro.getVisible() == null ? 1 : (libro.getVisible() ? 1 : 0);
        jdbc.update("INSERT INTO libro(isbn,titulo,editorial_id,anioPublicacion,autor_id,visible) VALUES(?,?,?,?,?,?)",
            libro.getIsbn(), libro.getTitulo(), libro.getEditorialId(), libro.getAnioPublicacion(), libro.getAutorId(), visibleInt);
            Long id = jdbc.queryForObject("SELECT last_insert_rowid()", Long.class);
            libro.setId(id);
            return libro;
        } else {
        int visibleInt = libro.getVisible() == null ? 1 : (libro.getVisible() ? 1 : 0);
        jdbc.update("UPDATE libro SET isbn=?, titulo=?, editorial_id=?, anioPublicacion=?, autor_id=?, visible=? WHERE id=?",
            libro.getIsbn(), libro.getTitulo(), libro.getEditorialId(), libro.getAnioPublicacion(), libro.getAutorId(), visibleInt, libro.getId());
            return libro;
        }
    }

    public void deleteById(Long id) {
        // logical delete: mark as not visible
        jdbc.update("UPDATE libro SET visible = 0 WHERE id = ?", id);
    }

    public void restoreById(Long id) {
        // logical restore: mark as visible
        jdbc.update("UPDATE libro SET visible = 1 WHERE id = ?", id);
    }

    public Libro findByIsbn(String isbn) {
        try {
            return jdbc.queryForObject("SELECT * FROM libro WHERE isbn = ?", mapper, isbn);
        } catch (Exception ex) { return null; }
    }
}
