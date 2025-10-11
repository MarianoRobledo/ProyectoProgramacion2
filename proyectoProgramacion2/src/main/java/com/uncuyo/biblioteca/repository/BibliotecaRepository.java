package com.uncuyo.biblioteca.repository;

import com.uncuyo.biblioteca.model.Biblioteca;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BibliotecaRepository {
    private final JdbcTemplate jdbc;

    public BibliotecaRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    private RowMapper<Biblioteca> mapper = (rs, rowNum) -> {
        Biblioteca b = new Biblioteca();
        b.setId(rs.getLong("id"));
        b.setNombre(rs.getString("nombre"));
        b.setDireccion(rs.getString("direccion"));
        b.setTelefono(rs.getString("telefono"));
        b.setEmail(rs.getString("email"));
        b.setAdministradorId(rs.getObject("administrador_id") != null ? rs.getLong("administrador_id") : null);
        return b;
    };

    public List<Biblioteca> findAll() { return jdbc.query("SELECT * FROM biblioteca", mapper); }

    public Biblioteca findById(Long id) { return jdbc.queryForObject("SELECT * FROM biblioteca WHERE id = ?", mapper, id); }

    public Biblioteca save(Biblioteca b) {
        if (b.getId() == null) {
            jdbc.update("INSERT INTO biblioteca(nombre,direccion,telefono,email,administrador_id) VALUES(?,?,?,?,?)",
                    b.getNombre(), b.getDireccion(), b.getTelefono(), b.getEmail(), b.getAdministradorId());
            Long id = jdbc.queryForObject("SELECT last_insert_rowid()", Long.class);
            b.setId(id);
            return b;
        } else {
            jdbc.update("UPDATE biblioteca SET nombre=?, direccion=?, telefono=?, email=?, administrador_id=? WHERE id=?",
                    b.getNombre(), b.getDireccion(), b.getTelefono(), b.getEmail(), b.getAdministradorId(), b.getId());
            return b;
        }
    }

    public void deleteById(Long id) { jdbc.update("DELETE FROM biblioteca WHERE id = ?", id); }
}
