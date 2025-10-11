package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Editorial;
import com.uncuyo.biblioteca.service.EditorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {
    private final EditorialService service;

    public EditorialController(EditorialService service) { this.service = service; }

    @GetMapping
    public List<Editorial> list() { return service.list(); }

    @GetMapping("/{id}")
    public ResponseEntity<Editorial> get(@PathVariable Long id) { Editorial e = service.get(id); if (e == null) return ResponseEntity.notFound().build(); return ResponseEntity.ok(e); }

    @PostMapping
    public Editorial create(@RequestBody Editorial e) { return service.save(e); }

    @PutMapping("/{id}")
    public Editorial update(@PathVariable Long id, @RequestBody Editorial e) { e.setId(id); return service.save(e); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
