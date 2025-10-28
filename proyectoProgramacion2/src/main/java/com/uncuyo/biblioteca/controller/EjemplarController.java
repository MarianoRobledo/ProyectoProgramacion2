package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Ejemplar;
import com.uncuyo.biblioteca.service.AdministradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/ejemplares")
public class EjemplarController {
    private final AdministradorService service;

    public EjemplarController(AdministradorService service) { this.service = service; }

    @GetMapping
    public List<Ejemplar> list() { return service.consultarEjemplares(); }

    @GetMapping("/{id}")
    public ResponseEntity<Ejemplar> get(@PathVariable Long id) { Ejemplar e = service.consultarEjemplar(id); if (e == null) return ResponseEntity.notFound().build(); return ResponseEntity.ok(e); }

    @PostMapping
    public Ejemplar create(@Valid @RequestBody Ejemplar e) { return service.agregar(e); }

    @PutMapping("/{id}")
    public Ejemplar update(@PathVariable Long id, @Valid @RequestBody Ejemplar e) { e.setId(id); return service.agregar(e); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.eliminarEjemplar(id); return ResponseEntity.noContent().build(); }
}
