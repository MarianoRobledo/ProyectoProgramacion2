package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Administrador;
import com.uncuyo.biblioteca.model.Bibliotecario;
import com.uncuyo.biblioteca.model.Cliente;
import com.uncuyo.biblioteca.service.AdministradorService;
import com.uncuyo.biblioteca.service.BibliotecarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final BibliotecarioService bibliotecarioService;
    private final AdministradorService administradorService;

    public AuthController( BibliotecarioService bs, AdministradorService as) {
        this.bibliotecarioService = bs;
        this.administradorService = as;
    }

    @GetMapping("/login")
    public Map<String, Object> login(@RequestParam Integer dni) {
        Map<String, Object> resp = new HashMap<>();
        
        Cliente c = administradorService.consultarCliente(dni);
        if (c != null) {
            resp.put("role", "Cliente");
            resp.put("user", c);
            return resp;
        }

        Administrador a = administradorService.consultarAdministrador(dni);
        if (a != null) {
            resp.put("role", "Administrador");
            resp.put("user", a);
            return resp;
        }

        Bibliotecario b = administradorService.consultarBibliotecario(dni);
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
