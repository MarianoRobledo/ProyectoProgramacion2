package com.uncuyo.biblioteca.repository;

import com.uncuyo.biblioteca.model.Administrador;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdministradorRepository {
    private final JdbcTemplate jdbc;

    public AdministradorRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    private RowMapper<Administrador> mapper = (rs, rowNum) -> {
        Administrador a = new Administrador();
        a.setLegajo((Integer) rs.getObject("legajo"));
        a.setNombre(rs.getString("nombre"));
        a.setApellido(rs.getString("apellido"));
        a.setTelefono(rs.getString("telefono"));
        a.setEmail(rs.getString("email"));
        a.setDni((Integer) rs.getObject("dni"));
        a.setFechaNacimiento(rs.getString("fechaNacimiento"));
        return a;
    };

    public List<Administrador> findAll() {
        return jdbc.query("SELECT p.*, b.legajo FROM bibliotecario b JOIN persona p ON b.persona_id = p.id WHERE b.is_admin = 1", mapper);
    }

    public Administrador findById(Long id) {
        return jdbc.queryForObject("SELECT p.*, b.legajo FROM bibliotecario b JOIN persona p ON b.persona_id = p.id WHERE b.id = ? AND b.is_admin = 1", mapper, id);
    }

    public Administrador findByDni(Integer dni) {
        try {
            return jdbc.queryForObject("SELECT p.*, b.legajo FROM bibliotecario b JOIN persona p ON b.persona_id = p.id WHERE p.dni = ? AND b.is_admin = 1", mapper, dni);
        } catch (Exception ex) {
            return null;
        }
    }

    public Administrador save(Administrador a) {
        if (a.getLegajo() == null) {
            // treat as new admin: insert persona then bibliotecario with is_admin=1
            jdbc.update("INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES(?,?,?,?,?,?)",
                    a.getNombre(), a.getApellido(), a.getFechaNacimiento(), a.getTelefono(), a.getEmail(), a.getDni());
            Long pid = jdbc.queryForObject("SELECT last_insert_rowid()", Long.class);
            jdbc.update("INSERT INTO bibliotecario(persona_id,legajo,is_admin) VALUES(?,?,?)", pid, a.getLegajo(), 1);
            // we don't set id on Administrador model here since it's not tracked in this model
            return a;
        } else {
            // update persona and bibliotecario
            Long pid = jdbc.queryForObject("SELECT persona_id FROM bibliotecario WHERE legajo = ?", Long.class, a.getLegajo());
            jdbc.update("UPDATE persona SET nombre=?, apellido=?, fechaNacimiento=?, telefono=?, email=?, dni=? WHERE id=?",
                    a.getNombre(), a.getApellido(), a.getFechaNacimiento(), a.getTelefono(), a.getEmail(), a.getDni(), pid);
            jdbc.update("UPDATE bibliotecario SET legajo=? WHERE persona_id=?", a.getLegajo(), pid);
            return a;
        }
    }

    public void deleteById(Long id) {
        Long pid = jdbc.queryForObject("SELECT persona_id FROM bibliotecario WHERE id = ?", Long.class, id);
        jdbc.update("DELETE FROM bibliotecario WHERE id = ?", id);
        jdbc.update("DELETE FROM persona WHERE id = ?", pid);
    }
}
