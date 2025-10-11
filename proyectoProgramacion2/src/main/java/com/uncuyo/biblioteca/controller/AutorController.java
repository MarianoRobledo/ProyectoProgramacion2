package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Autor;
import com.uncuyo.biblioteca.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    private final AutorService service;

    public AutorController(AutorService service) { this.service = service; }

    @GetMapping
    public List<Autor> list() { return service.list(); }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> get(@PathVariable Long id) { 
        Autor a = service.get(id); 
        if (a == null) return ResponseEntity.notFound().build(); 
        return ResponseEntity.ok(a); 
    }

    @PostMapping
    public Autor create(@RequestBody Autor a) { return service.save(a); }

    @PutMapping("/{id}")
    public Autor update(@PathVariable Long id, @RequestBody Autor a) { a.setId(id); return service.save(a); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
