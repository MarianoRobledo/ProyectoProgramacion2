package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Administrador;
import com.uncuyo.biblioteca.model.Bibliotecario;
import com.uncuyo.biblioteca.model.Cliente;
import com.uncuyo.biblioteca.service.AdministradorService;
import com.uncuyo.biblioteca.service.BibliotecarioService;
import com.uncuyo.biblioteca.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final ClienteService clienteService;
    private final BibliotecarioService bibliotecarioService;
    private final AdministradorService administradorService;

    public AuthController(ClienteService cs, BibliotecarioService bs, AdministradorService as) {
        this.clienteService = cs;
        this.bibliotecarioService = bs;
        this.administradorService = as;
    }

    @GetMapping("/login")
    public Map<String, Object> login(@RequestParam Integer dni) {
        Map<String, Object> resp = new HashMap<>();
        
        Cliente c = clienteService.findByDni(dni);
        if (c != null) {
            resp.put("role", "Cliente");
            resp.put("user", c);
            return resp;
        }

        Administrador a = administradorService.findByDni(dni);
        if (a != null) {
            resp.put("role", "Administrador");
            resp.put("user", a);
            return resp;
        }

        Bibliotecario b = bibliotecarioService.findByDni(dni);
        if (b != null) {
            resp.put("role", "Bibliotecario");
            resp.put("user", b);
            return resp;
        }

        resp.put("role", null);
        resp.put("user", null);
        return resp;
    }
}
