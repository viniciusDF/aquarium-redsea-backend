package com.redsea250.controller;

import com.redsea250.security.JwtUtil;
import com.redsea250.model.Usuario;
import com.redsea250.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioRepository repository,
                          PasswordEncoder encoder,
                          JwtUtil jwtUtil) {
        this.repository = repository;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String,String> body){

        String username = body.get("username");
        String password = body.get("password");

        Usuario usuario = repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if(!encoder.matches(password, usuario.getPassword())){
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtUtil.generateToken(username);

        return Map.of("token", token);
    }
}