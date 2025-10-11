package com.uncuyo.biblioteca.repository;

import com.uncuyo.biblioteca.model.Editorial;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EditorialRepository {
    private final JdbcTemplate jdbc;

    public EditorialRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    private RowMapper<Editorial> mapper = (rs, rowNum) -> {
        Editorial e = new Editorial();
        e.setId(rs.getLong("id"));
        e.setNombre(rs.getString("nombre"));
        e.setPais(rs.getString("pais"));
        e.setDireccion(rs.getString("direccion"));
        e.setTelefono(rs.getString("telefono"));
        e.setEmail(rs.getString("email"));
        return e;
    };

    public List<Editorial> findAll() { return jdbc.query("SELECT * FROM editorial", mapper); }

    public Editorial findById(Long id) { return jdbc.queryForObject("SELECT * FROM editorial WHERE id = ?", mapper, id); }

    public Editorial save(Editorial e) {
        if (e.getId() == null) {
            jdbc.update("INSERT INTO editorial(nombre,pais,direccion,telefono,email) VALUES(?,?,?,?,?)",
                    e.getNombre(), e.getPais(), e.getDireccion(), e.getTelefono(), e.getEmail());
            Long id = jdbc.queryForObject("SELECT last_insert_rowid()", Long.class);
            e.setId(id);
            return e;
        } else {
            jdbc.update("UPDATE editorial SET nombre=?, pais=?, direccion=?, telefono=?, email=? WHERE id=?",
                    e.getNombre(), e.getPais(), e.getDireccion(), e.getTelefono(), e.getEmail(), e.getId());
            return e;
        }
    }

    public void deleteById(Long id) { jdbc.update("DELETE FROM editorial WHERE id = ?", id); }
}
