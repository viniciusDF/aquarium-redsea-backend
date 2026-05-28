package com.redsea250.config;

import com.redsea250.model.Usuario;
import com.redsea250.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository repository, PasswordEncoder encoder) {
        return args -> {

            if (repository.findByUsername("admin").isEmpty()) {

                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("1234"));
                admin.setRole("ADMIN");

                repository.save(admin);

                System.out.println("ADMIN criado automaticamente");
            }

        };
    }
}