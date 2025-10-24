package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Libro;
import com.uncuyo.biblioteca.service.AdministradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    
    private final AdministradorService service;
    
    public LibroController(AdministradorService service) { this.service = service; }

    @GetMapping
    public List<Libro> list() { return service.consultarLibros(); }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> get(@PathVariable Long id) {
        Libro l = service.consultarLibro(id);
        if (l == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(l);
    }

    @PostMapping
    public Libro create(@RequestBody Libro libro) { return service.agregar(libro); }

    @PutMapping("/{id}")
    public Libro update(@PathVariable Long id, @RequestBody Libro libro) { libro.setId(id); return service.agregar(libro); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.eliminarLibro(id); return ResponseEntity.noContent().build(); }
}
