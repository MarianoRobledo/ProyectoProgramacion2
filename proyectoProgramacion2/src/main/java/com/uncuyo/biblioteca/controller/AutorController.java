package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Autor;
import com.uncuyo.biblioteca.service.AdministradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    private final AdministradorService service;

    public AutorController(AdministradorService service) { this.service = service; }

    @GetMapping
    public List<Autor> list() { return service.consultarAutores(); }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> get(@PathVariable Long id) { 
        Autor a = service.consultarAutor(id); 
        if (a == null) return ResponseEntity.notFound().build(); 
        return ResponseEntity.ok(a); 
    }

    @PostMapping
    public Autor create(@RequestBody Autor a) { return service.agregar(a); }

    @PutMapping("/{id}")
    public Autor update(@PathVariable Long id, @RequestBody Autor a) { a.setId(id); return service.agregar(a); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.eliminarAutor(id); return ResponseEntity.noContent().build(); }
}
