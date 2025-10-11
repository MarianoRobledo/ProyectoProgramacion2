package com.uncuyo.biblioteca.repository;

import com.uncuyo.biblioteca.model.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {
    private final JdbcTemplate jdbc;

    public ClienteRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    private RowMapper<Cliente> mapper = (rs, rowNum) -> {
        Cliente c = new Cliente();
        // cliente id will be aliased as c_id in queries
        try {
            c.setId(rs.getLong("c_id"));
        } catch (Exception ex) {
            c.setId(rs.getLong("id"));
        }
        Object pid = rs.getObject("persona_id");
        if (pid != null) c.setPersonaId(((Number) pid).longValue());
        c.setLegajo((Integer) (rs.getObject("legajo") == null ? null : rs.getObject("legajo")));
        c.setReservedBooks((Integer) (rs.getObject("reserved_books") == null ? 0 : rs.getObject("reserved_books")));

        // persona fields (inherited)
        try { c.setNombre(rs.getString("nombre")); } catch (Exception ignored) {}
        try { c.setApellido(rs.getString("apellido")); } catch (Exception ignored) {}
        try { c.setDni((Integer) rs.getObject("dni")); } catch (Exception ignored) {}
        try { c.setEmail(rs.getString("email")); } catch (Exception ignored) {}
        try { c.setTelefono(rs.getString("telefono")); } catch (Exception ignored) {}

        return c;
    };

    public List<Cliente> findAll() {
        return jdbc.query("SELECT c.id as c_id, c.persona_id, c.legajo, c.reserved_books, p.* FROM cliente c LEFT JOIN persona p ON c.persona_id = p.id", mapper);
    }

    public Cliente findById(Long id) {
        return jdbc.queryForObject("SELECT c.id as c_id, c.persona_id, c.legajo, c.reserved_books, p.* FROM cliente c LEFT JOIN persona p ON c.persona_id = p.id WHERE c.id = ?", mapper, id);
    }

    public Cliente findByDni(Integer dni) {
        try {
            return jdbc.queryForObject("SELECT c.id as c_id, c.persona_id, c.legajo, c.reserved_books, p.* FROM cliente c JOIN persona p ON c.persona_id = p.id WHERE p.dni = ?", mapper, dni);
        } catch (Exception ex) {
            return null;
        }
    }

    public Cliente save(Cliente c) {
        if (c.getId() == null) {
            // insert persona first
            jdbc.update("INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES(?,?,?,?,?,?)",
                    c.getNombre(), c.getApellido(), null, c.getTelefono(), c.getEmail(), c.getDni());
            Long personId = jdbc.queryForObject("SELECT last_insert_rowid()", Long.class);
            jdbc.update("INSERT INTO cliente(persona_id,legajo,reserved_books) VALUES(?,?,?)",
                    personId, c.getLegajo(), c.getReservedBooks());
            Long id = jdbc.queryForObject("SELECT last_insert_rowid()", Long.class);
            c.setId(id);
            c.setPersonaId(personId);
            return c;
        } else {
            // update persona
            Long personId = null;
            try {
                personId = jdbc.queryForObject("SELECT persona_id FROM cliente WHERE id = ?", Long.class, c.getId());
            } catch (Exception ignored) { personId = null; }
            if (personId == null) {
                // insert persona
                jdbc.update("INSERT INTO persona(nombre,apellido,fechaNacimiento,telefono,email,dni) VALUES(?,?,?,?,?,?)",
                        c.getNombre(), c.getApellido(), null, c.getTelefono(), c.getEmail(), c.getDni());
                Long newPersonId = jdbc.queryForObject("SELECT last_insert_rowid()", Long.class);
                jdbc.update("UPDATE cliente SET persona_id=? WHERE id=?", newPersonId, c.getId());
                personId = newPersonId;
            } else {
                jdbc.update("UPDATE persona SET nombre=?, apellido=?, fechaNacimiento=?, telefono=?, email=?, dni=? WHERE id=?",
                        c.getNombre(), c.getApellido(), null, c.getTelefono(), c.getEmail(), c.getDni(), personId);
            }
            // update cliente
            jdbc.update("UPDATE cliente SET legajo=?, reserved_books=? WHERE id=?", c.getLegajo(), c.getReservedBooks(), c.getId());
            c.setPersonaId(personId);
            return c;
        }
    }

    public void deleteById(Long id) {
        // delete cliente then persona if exists
    Long personId = null;
    try { personId = jdbc.queryForObject("SELECT persona_id FROM cliente WHERE id = ?", Long.class, id); } catch (Exception ignored) { personId = null; }
    jdbc.update("DELETE FROM cliente WHERE id = ?", id);
    if (personId != null) jdbc.update("DELETE FROM persona WHERE id = ?", personId);
    }
}
