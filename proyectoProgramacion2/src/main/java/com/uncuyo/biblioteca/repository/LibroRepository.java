package com.uncuyo.biblioteca.repository;

import com.uncuyo.biblioteca.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LibroRepository {
    @Autowired
    private JdbcTemplate jdbc;

    private final RowMapper<Libro> mapper = new RowMapper<Libro>() {
        public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
            Libro l = new Libro();
            l.setId(rs.getInt("id"));
            l.setIsbn(rs.getString("isbn"));
            l.setTitulo(rs.getString("titulo"));
            l.setEditorialId(rs.getObject("editorial_id") == null ? null : rs.getInt("editorial_id"));
            l.setAutorId(rs.getObject("autor_id") == null ? null : rs.getInt("autor_id"));
            l.setDisponible(rs.getInt("disponible") == 1);
            return l;
        }
    };

    public List<Libro> findAll() {
        return jdbc.query("SELECT * FROM libro", mapper);
    }

    public Libro findById(int id) {
        return jdbc.queryForObject("SELECT * FROM libro WHERE id = ?", new Object[]{id}, mapper);
    }

    public int save(Libro libro) {
        if (libro.getId() == null) {
            jdbc.update("INSERT INTO libro (isbn,titulo,editorial_id,anioPublicacion,autor_id,disponible) VALUES (?,?,?,?,?,?)",
                    libro.getIsbn(), libro.getTitulo(), libro.getEditorialId(), null, libro.getAutorId(), libro.getDisponible() ? 1 : 0);
            Integer id = jdbc.queryForObject("SELECT last_insert_rowid()", Integer.class);
            return id == null ? -1 : id;
        } else {
            jdbc.update("UPDATE libro SET isbn=?,titulo=?,editorial_id=?,anioPublicacion=?,autor_id=?,disponible=? WHERE id=?",
                    libro.getIsbn(), libro.getTitulo(), libro.getEditorialId(), null, libro.getAutorId(), libro.getDisponible() ? 1 : 0, libro.getId());
            return libro.getId();
        }
    }

    public void delete(int id) {
        jdbc.update("DELETE FROM libro WHERE id = ?", id);
    }
}
