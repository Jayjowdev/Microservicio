package com.microservicio.publicacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.publicacion.model.Publicacion;
import com.microservicio.publicacion.service.PublicacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/publicacion")
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "Publicacion", description = "API para gestion de publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @Operation(summary = "Guardar nueva publicacion", 
               description = "Crea una nueva publicacion en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Publicacion creada exitosamente",
                     content = @Content(mediaType = "application/json", 
                                      schema = @Schema(implementation = Publicacion.class))),
        @ApiResponse(responseCode = "400", description = "Datos invalidos", content = @Content)
    })
    @PostMapping("/guardar")
    public ResponseEntity<Publicacion> guardarPublicacion(
            @Parameter(description = "Datos de la publicacion a crear", required = true)
            @RequestBody Publicacion publicacion) {
        Publicacion resultado = publicacionService.guardarPublicacion(publicacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }
    
    @Operation(summary = "Listar todas las publicaciones", 
               description = "Obtiene una lista completa de todas las publicaciones registradas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente",
                     content = @Content(mediaType = "application/json", 
                                      schema = @Schema(implementation = Publicacion.class)))
    })
    @GetMapping("/listar")
    public ResponseEntity<List<Publicacion>> listarPublicaciones() {
        List<Publicacion> publicaciones = publicacionService.listarPublicaciones();
        return ResponseEntity.ok(publicaciones);
    }
}