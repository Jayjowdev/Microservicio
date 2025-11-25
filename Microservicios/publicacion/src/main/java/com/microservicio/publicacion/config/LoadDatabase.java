package com.microservicio.publicacion.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservicio.publicacion.model.Publicacion;
import com.microservicio.publicacion.model.Publicacion.TipoContrato;
import com.microservicio.publicacion.repository.PublicacionRepository;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(PublicacionRepository publicacionRepository) {
        return args -> {
            // Database initialization logic can be added here
            if(publicacionRepository.count() == 0) {
                Publicacion publicacion = new Publicacion();
                publicacion.setTitulo("Desarrollador Java Senior");
                publicacion.setEmpresa("Tech Solutions Inc.");
                publicacion.setUbicacion("Ciudad de México");
                publicacion.setSalario("$50,000 - $70,000 MXN");
                publicacion.setDescripcion("Buscamos desarrollador Java con experiencia en Spring Boot y microservicios");
                publicacion.setRequisitos("3+ años de experiencia en Java, conocimiento de Spring Framework, bases de datos relacionales");
                publicacion.setTipoContrato(TipoContrato.TIEMPO_COMPLETO);
                publicacionRepository.save(publicacion);

        
                System.out.println("Base de datos esta vacia. Puedes agregar datos iniciales aquí.");
            } else {
                System.out.println("La Base de datos ya contiene datos.");
            }
        };
    }
}
