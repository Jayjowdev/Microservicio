package com.microservicio.usuario.DTO;

public record RegisterRequest(
    String nombre,
    String correo,
    String usuario,
    String password,
    String contrasena
) {}
