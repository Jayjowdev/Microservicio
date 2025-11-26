package com.microservicio.usuario.DTO;

public record LoginRequest(
    String usuario,
    String contrasena
) {}
