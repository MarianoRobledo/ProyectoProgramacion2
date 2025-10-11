package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Libro;
import com.uncuyo.biblioteca.service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private final LibroService service;

    public LibroController(LibroService service) { this.service = service; }

    @GetMapping
    public List<Libro> list() { return service.list(); }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> get(@PathVariable Long id) {
        Libro l = service.get(id);
        if (l == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(l);
    }

    @PostMapping
    public Libro create(@RequestBody Libro libro) { return service.save(libro); }

    @PutMapping("/{id}")
    public Libro update(@PathVariable Long id, @RequestBody Libro libro) { libro.setId(id); return service.save(libro); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
