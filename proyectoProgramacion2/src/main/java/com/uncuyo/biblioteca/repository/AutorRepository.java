package com.uncuyo.biblioteca.repository;

import com.uncuyo.biblioteca.model.Autor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutorRepository {
    private final JdbcTemplate jdbc;

    public AutorRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    private RowMapper<Autor> mapper = (rs, rowNum) -> {
        Autor a = new Autor();
        a.setId(rs.getLong("id"));
        a.setNombre(rs.getString("nombre"));
        a.setFechaDeNacimiento(rs.getString("fechaDeNacimiento"));
        a.setFechaDeFallecimiento(rs.getString("fechaDeFallecimiento"));
        a.setNacionalidad(rs.getString("nacionalidad"));
        return a;
    };

    public List<Autor> findAll() { return jdbc.query("SELECT * FROM autor", mapper); }

    public Autor findById(Long id) { return jdbc.queryForObject("SELECT * FROM autor WHERE id = ?", mapper, id); }

    public Autor save(Autor a) {
        if (a.getId() == null) {
            jdbc.update("INSERT INTO autor(nombre,fechaDeNacimiento,fechaDeFallecimiento,nacionalidad) VALUES(?,?,?,?)",
                    a.getNombre(), a.getFechaDeNacimiento(), a.getFechaDeFallecimiento(), a.getNacionalidad());
            Long id = jdbc.queryForObject("SELECT last_insert_rowid()", Long.class);
            a.setId(id);
            return a;
        } else {
            jdbc.update("UPDATE autor SET nombre=?, fechaDeNacimiento=?, fechaDeFallecimiento=?, nacionalidad=? WHERE id=?",
                    a.getNombre(), a.getFechaDeNacimiento(), a.getFechaDeFallecimiento(), a.getNacionalidad(), a.getId());
            return a;
        }
    }

    public void deleteById(Long id) { jdbc.update("DELETE FROM autor WHERE id = ?", id); }
}
