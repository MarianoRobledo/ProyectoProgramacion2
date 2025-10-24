package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Bibliotecario;
import com.uncuyo.biblioteca.service.AdministradorService;
import com.uncuyo.biblioteca.service.BibliotecarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecarios")
public class BibliotecarioController {

    private final AdministradorService service;

    public BibliotecarioController(AdministradorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Bibliotecario> list() {
        return service.consultarBibliotecarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> get(@PathVariable Integer id) {
        Bibliotecario b = service.consultarBibliotecario(id);
        if (b == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(b);
    }

    @PostMapping
    public Bibliotecario create(@RequestBody Bibliotecario b) {
        return service.agregar(b);
    }

    @PutMapping("/{id}")
    public Bibliotecario update(@PathVariable Long id, @RequestBody Bibliotecario b) {
        b.setId(id);
        return service.agregar(b);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.eliminarBibliotecario(id);
        return ResponseEntity.noContent().build();
    }
}
