package com.redsea250.config;

import com.redsea250.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Mantém as rotas atuais do seu front-end/autenticação
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/auth/register").permitAll()

                        // Se o seu AuthController usar a rota com "/api/auth/...", mantenha esta também:
                        .requestMatchers("/api/auth/**").permitAll()

                        // Libera a ESP32 para enviar as leituras do aquário sem precisar de token JWT
                        .requestMatchers("/api/esp/**").permitAll()

                        // Qualquer outra requisição (como o Dashboard do front) vai exigir o Token
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}