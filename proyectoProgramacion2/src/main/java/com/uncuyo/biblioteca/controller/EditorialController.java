package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Editorial;
import com.uncuyo.biblioteca.service.AdministradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {
    private final AdministradorService service;

    public EditorialController(AdministradorService service) { this.service = service; }

    @GetMapping
    public List<Editorial> list() { return service.consultarEditoriales(); }

    @GetMapping("/{id}")
    public ResponseEntity<Editorial> get(@PathVariable Long id) { Editorial e = service.consultarEditorial(id); if (e == null) return ResponseEntity.notFound().build(); return ResponseEntity.ok(e); }

    @PostMapping
    public Editorial create(@RequestBody Editorial e) { return service.agregar(e); }

    @PutMapping("/{id}")
    public Editorial update(@PathVariable Long id, @RequestBody Editorial e) { e.setId(id); return service.agregar(e); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.eliminarEditorial(id); return ResponseEntity.noContent().build(); }
}
