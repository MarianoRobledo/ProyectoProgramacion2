package com.uncuyo.biblioteca.controller;

import com.uncuyo.biblioteca.model.Persona;
import com.uncuyo.biblioteca.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private PersonaService personaService;

    @GetMapping({"/","/index"})
    public String index(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() { return "login"; }

    @PostMapping("/login")
    public String login(@RequestParam String email, HttpSession session, Model model) {
        Persona p = personaService.findByEmail(email);
        if (p == null) {
            model.addAttribute("error","Usuario no encontrado");
            return "login";
        }
        session.setAttribute("user", p);
        return "redirect:/libros";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
