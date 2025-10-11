package com.uncuyo.biblioteca.service;

import com.uncuyo.biblioteca.abm.IABMCliente;
import com.uncuyo.biblioteca.model.Cliente;
import com.uncuyo.biblioteca.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IABMCliente {
    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) { this.repo = repo; }

    public List<Cliente> list() { return repo.findAll(); }
    public Cliente get(Long id) { return repo.findById(id); }
    public Cliente save(Cliente c) { return repo.save(c); }
    public void delete(Long id) { repo.deleteById(id); }

    @Override
    public Cliente agregarCliente(Cliente c) { return save(c); }

    @Override
    public Cliente modificarCliente(Cliente c) { return save(c); }

    @Override
    public void eliminarCliente(Long id) { delete(id); }

    @Override
    public List<Cliente> consultarClientes() { return list(); }

    // lookup by DNI
    public Cliente findByDni(Integer dni) { return repo.findByDni(dni); }
}
