package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Cliente;
import com.uncuyo.biblioteca.service.AdministradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final AdministradorService service;

    public ClienteController(AdministradorService service) { this.service = service; }

    @GetMapping
    public List<Cliente> list() { return service.consultarClientes(); }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable Integer id) { Cliente c = service.consultarCliente(id); if (c == null) return ResponseEntity.notFound().build(); return ResponseEntity.ok(c); }

    @PostMapping
    public Cliente create(@Valid @RequestBody Cliente cliente) { return service.agregar(cliente); }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @Valid @RequestBody Cliente cliente) { cliente.setId(id); return service.agregar(cliente); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.eliminarCliente(id); return ResponseEntity.noContent().build(); }
}
