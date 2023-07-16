package com.remax.alquileres.controladores;

import com.remax.alquileres.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/")
@Controller
public class PortalControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @GetMapping("/")
    public String inicio() {
        return "inicio.html";
    }
    
    @GetMapping("/login")
    public String login() {
        return "formulario-login.html";
    }
    
    @GetMapping("/registro")
    public String registro() {
        return "formulario-registro.html";
    }
    
    @PostMapping("/registrar")
    public String registrar(@RequestParam String email, @RequestParam String clave) {
        usuarioServicio.registrarUsuario(email, clave);
        return "redirect:/login";
    }
    
}
