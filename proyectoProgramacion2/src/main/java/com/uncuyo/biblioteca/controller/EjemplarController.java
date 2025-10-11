package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Ejemplar;
import com.uncuyo.biblioteca.service.EjemplarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejemplares")
public class EjemplarController {
    private final EjemplarService service;

    public EjemplarController(EjemplarService service) { this.service = service; }

    @GetMapping
    public List<Ejemplar> list() { return service.list(); }

    @GetMapping("/{id}")
    public ResponseEntity<Ejemplar> get(@PathVariable Long id) { Ejemplar e = service.get(id); if (e == null) return ResponseEntity.notFound().build(); return ResponseEntity.ok(e); }

    @PostMapping
    public Ejemplar create(@RequestBody Ejemplar e) { return service.save(e); }

    @PutMapping("/{id}")
    public Ejemplar update(@PathVariable Long id, @RequestBody Ejemplar e) { e.setId(id); return service.save(e); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
