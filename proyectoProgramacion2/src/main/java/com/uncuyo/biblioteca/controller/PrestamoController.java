package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Prestamo;
import com.uncuyo.biblioteca.service.PrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    private final PrestamoService service;

    public PrestamoController(PrestamoService service) { this.service = service; }

    @GetMapping
    public List<Prestamo> list() { return service.list(); }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Prestamo p) {
        try {
            Prestamo result = service.create(p);
            return ResponseEntity.ok(result);
        } catch (IllegalStateException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/{id}/devolver")
    public ResponseEntity<Void> devolver(@PathVariable Long id) { service.closeLoan(id); return ResponseEntity.ok().build(); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.eliminarPrestamo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> update(@PathVariable Long id, @RequestBody Prestamo p) {
        p.setId(id);
        Prestamo updated = service.modificarPrestamo(p);
        return ResponseEntity.ok(updated);
    }
}
