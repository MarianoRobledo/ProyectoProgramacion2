package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Administrador;
import com.uncuyo.biblioteca.service.AdministradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {
    private final AdministradorService service;

    public AdministradorController(AdministradorService service) { this.service = service; }

    @GetMapping
    public List<Administrador> list() { return service.consultarAdministradores(); }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> get(@PathVariable Integer id) { Administrador a = service.consultarAdministrador(id); if (a == null) return ResponseEntity.notFound().build(); return ResponseEntity.ok(a); }

    @PostMapping
    public Administrador create(@Valid @RequestBody Administrador a) { return service.agregar(a); }

    @PutMapping("/{id}")
    public Administrador update(@PathVariable Long id, @Valid @RequestBody Administrador a) { /* prefer to update by id if model exposes it */ return service.modificar(a); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.eliminarAdministrador(id); return ResponseEntity.noContent().build(); }
}
