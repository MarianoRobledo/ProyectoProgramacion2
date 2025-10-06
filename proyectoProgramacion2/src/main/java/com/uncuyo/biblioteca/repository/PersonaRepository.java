package com.uncuyo.biblioteca.repository;

import com.uncuyo.biblioteca.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonaRepository {
    @Autowired
    private JdbcTemplate jdbc;

    private final RowMapper<Persona> mapper = new RowMapper<Persona>() {
        public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
            Persona p = new Persona();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setApellido(rs.getString("apellido"));
            p.setEmail(rs.getString("email"));
            p.setTelefono(rs.getString("telefono"));
            p.setRol(rs.getString("rol"));
            return p;
        }
    };

    public List<Persona> findAll() {
        return jdbc.query("SELECT * FROM persona", mapper);
    }

    public Persona findById(int id) {
        return jdbc.queryForObject("SELECT * FROM persona WHERE id = ?", new Object[]{id}, mapper);
    }

    public Persona findByEmail(String email) {
        List<Persona> list = jdbc.query("SELECT * FROM persona WHERE email = ?", new Object[]{email}, mapper);
        return list.isEmpty() ? null : list.get(0);
    }
}
