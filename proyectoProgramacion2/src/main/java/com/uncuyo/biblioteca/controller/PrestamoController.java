package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Prestamo;
import com.uncuyo.biblioteca.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    private final AdministradorService service;

    public PrestamoController(AdministradorService service) { this.service = service; }

    @GetMapping
    public List<Prestamo> list() { return service.consultarPrestamos(); }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Prestamo p) {
        try {
            Prestamo result = service.agregar(p);
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
        Prestamo updated = service.modificar(p);
        return ResponseEntity.ok(updated);
    }
}
