package com.uncuyo.biblioteca.repository;

import com.uncuyo.biblioteca.model.Bibliotecario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BibliotecarioRepository {
    private final JdbcTemplate jdbc;

    public BibliotecarioRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    private RowMapper<Bibliotecario> mapper = (rs, rowNum) -> {
        Bibliotecario b = new Bibliotecario();
        b.setId(rs.getLong("b_id"));
        b.setLegajo((Integer) rs.getObject("legajo"));
        b.setNombre(rs.getString("nombre"));
        b.setApellido(rs.getString("apellido"));
        b.setFechaNacimiento(rs.getString("fechaNacimiento"));
        b.setTelefono(rs.getString("telefono"));
        b.setEmail(rs.getString("email"));
        b.setDni((Integer) rs.getObject("dni"));
        return b;
    };

    public List<Bibliotecario> findAll() {
        return jdbc.query("SELECT b.id as b_id, b.legajo, p.* FROM bibliotecario b JOIN persona p ON b.persona_id = p.id", mapper);
    }

    public Bibliotecario findById(Long id) {
        return jdbc.queryForObject("SELECT b.id as b_id, p.* FROM bibliotecario b JOIN persona p ON b.persona_id = p.id WHERE b.id = ?", mapper, id);
    }

    public Bibliotecario findByDni(Integer dni) {
        try {
            return jdbc.queryForObject("SELECT b.id as b_id, b.legajo, p.* FROM bibliotecario b JOIN persona p ON b.persona_id = p.id WHERE p.dni = ?", mapper, dni);
        } catch (Exception ex) {
            return null;
        }
    }

    public Bibliotecario findByLegajo(Integer legajo) {
        if (legajo == null) return null;
        try {
            return jdbc.queryForObject("SELECT b.id as b_id, b.legajo, p.* FROM bibliotecario b JOIN persona p ON b.persona_id = p.id WHERE b.legajo = ?", mapper, legajo);
        } catch (Exception ex) {
            return null;
        }
    }

    public Bibliotecario save(Bibliotecario b) {
        if (b.getId() == null) {
            // insert persona
            jdbc.update("INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES(?,?,?,?,?,?)",
                    b.getNombre(), b.getApellido(), b.getFechaNacimiento(), b.getTelefono(), b.getEmail(), b.getDni());
            Long personId = jdbc.queryForObject("SELECT last_insert_rowid()", Long.class);
            jdbc.update("INSERT INTO bibliotecario(persona_id,legajo,is_admin) VALUES(?,?,?)", personId, b.getLegajo(), 0);
            Long id = jdbc.queryForObject("SELECT last_insert_rowid()", Long.class);
            b.setId(id);
            return b;
        } else {
            // update persona and bibliotecario
            // get persona id
            Long personId = jdbc.queryForObject("SELECT persona_id FROM bibliotecario WHERE id = ?", Long.class, b.getId());
            jdbc.update("UPDATE persona SET nombre=?, apellido=?, fechaNacimiento=?, telefono=?, email=?, dni=? WHERE id=?",
                    b.getNombre(), b.getApellido(), b.getFechaNacimiento(), b.getTelefono(), b.getEmail(), b.getDni(), personId);
            jdbc.update("UPDATE bibliotecario SET legajo=? WHERE id=?", b.getLegajo(), b.getId());
            return b;
        }
    }

    public void deleteById(Long id) {
        // delete bibliotecario then persona
        Long personId = jdbc.queryForObject("SELECT persona_id FROM bibliotecario WHERE id = ?", Long.class, id);
        jdbc.update("DELETE FROM bibliotecario WHERE id = ?", id);
        jdbc.update("DELETE FROM persona WHERE id = ?", personId);
    }
}
