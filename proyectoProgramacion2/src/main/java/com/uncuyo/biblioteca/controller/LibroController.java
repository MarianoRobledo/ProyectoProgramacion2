package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Libro;
import com.uncuyo.biblioteca.model.Persona;
import com.uncuyo.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public String list(Model model, HttpSession session) {
        model.addAttribute("libros", libroService.listAll());
        model.addAttribute("user", session.getAttribute("user"));
        return "libros/list";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model, HttpSession session) {
        Persona user = (Persona) session.getAttribute("user");
        if (user == null || "CLIENTE".equals(user.getRol())) {
            return "redirect:/libros";
        }
        model.addAttribute("libro", new Libro());
        return "libros/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Libro libro, HttpSession session) {
        Persona user = (Persona) session.getAttribute("user");
        if (user == null || "CLIENTE".equals(user.getRol())) {
            return "redirect:/libros";
        }
        libroService.save(libro);
        return "redirect:/libros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model, HttpSession session) {
        Persona user = (Persona) session.getAttribute("user");
        if (user == null || "CLIENTE".equals(user.getRol())) {
            return "redirect:/libros";
        }
        model.addAttribute("libro", libroService.get(id));
        return "libros/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, HttpSession session) {
        Persona user = (Persona) session.getAttribute("user");
        if (user == null || "CLIENTE".equals(user.getRol())) {
            return "redirect:/libros";
        }
        libroService.delete(id);
        return "redirect:/libros";
    }
}
