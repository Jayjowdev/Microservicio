package com.microservicio.usuario.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.usuario.model.Login;
import com.microservicio.usuario.service.LoginService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173") // para conectar con frontend React
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> autenticarUsuario(@RequestBody Map<String, String> credentials) {
        try {
            String usuario = credentials.get("usuario");
            String contrasena = credentials.get("contrasena");

            Login login = loginService.autenticarUsuario(usuario, contrasena);
            
            // Retornar información del usuario autenticado (sin la contraseña)
            return ResponseEntity.ok(Map.of(
                "id", login.getId(),
                "usuario", login.getUsuario(),
                "role", login.getRole(),
                "mensaje", "Login exitoso"
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                "mensaje", e.getMessage()
            ));
        }
    }

    @GetMapping("/check/{usuario}")
    public ResponseEntity<?> verificarUsuario(@PathVariable String usuario) {
        boolean existe = loginService.existeUsuario(usuario);
        return ResponseEntity.ok(Map.of(
            "existe", existe
        ));
    }
}
