package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Cliente;
import com.uncuyo.biblioteca.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) { this.service = service; }

    @GetMapping
    public List<Cliente> list() { return service.list(); }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable Long id) { Cliente c = service.get(id); if (c == null) return ResponseEntity.notFound().build(); return ResponseEntity.ok(c); }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) { return service.save(cliente); }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) { cliente.setId(id); return service.save(cliente); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
