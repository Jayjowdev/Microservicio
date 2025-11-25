package com.microservicio.membresia.config;

import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservicio.membresia.model.Membresia;
import com.microservicio.membresia.repository.MembresiaRepository;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(MembresiaRepository membresiaRepository) {
        return args -> {
            // Database initialization logic can be added here
            if(membresiaRepository.count() == 0) {
                Membresia membresia = new Membresia();
                membresia.setTipoMembresia("Premium");
                membresia.setTotal(99.99);
                membresia.setFechaInicio(new Date());
                
                // Calcular fecha fin 30 días después
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.DAY_OF_MONTH, 30);
                membresia.setFechaFin(cal.getTime());
                
                membresiaRepository.save(membresia);

        
                System.out.println("Base de datos está vacía. Puedes agregar datos iniciales aquí.");
            } else {
                System.out.println("La Base de datos ya contiene datos.");
            }
        };
    }
}
