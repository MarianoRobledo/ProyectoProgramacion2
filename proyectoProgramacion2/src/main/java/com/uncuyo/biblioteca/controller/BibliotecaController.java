package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Biblioteca;
import com.uncuyo.biblioteca.service.BibliotecaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecas")
public class BibliotecaController {
    private final BibliotecaService service;

    public BibliotecaController(BibliotecaService service) { this.service = service; }

    @GetMapping
    public List<Biblioteca> list() { return service.list(); }

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> get(@PathVariable Long id) { Biblioteca b = service.get(id); if (b == null) return ResponseEntity.notFound().build(); return ResponseEntity.ok(b); }

    @PostMapping
    public Biblioteca create(@RequestBody Biblioteca b) { return service.save(b); }

    @PutMapping("/{id}")
    public Biblioteca update(@PathVariable Long id, @RequestBody Biblioteca b) { b.setId(id); return service.save(b); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
