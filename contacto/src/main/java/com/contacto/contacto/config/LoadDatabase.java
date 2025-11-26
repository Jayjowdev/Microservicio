package com.contacto.contacto.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.contacto.contacto.model.Contacto;
import com.contacto.contacto.repository.ContactoRepository;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(ContactoRepository cont) {
        return args -> {
            // Database initialization logic can be added here
            if(cont.count() == 0) {
                Contacto contacto = new Contacto();
                contacto.setNombre("John");
                contacto.setEmail("John@example.com");
                cont.save(contacto);

        
                System.out.println("La Base de datos esta vacia. Puedes agregar datos iniciales aquí.");
            } else {
                System.out.println("La base de datos ya contiene datos.");
            }
        };
    }
}
