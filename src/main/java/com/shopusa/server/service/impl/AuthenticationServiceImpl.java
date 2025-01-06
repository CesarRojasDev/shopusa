package com.shopusa.server.service.impl;

import com.shopusa.server.dto.UsuarioResponseDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.shopusa.server.dao.request.SignInRequest;
import com.shopusa.server.dao.request.SignUpRequest;
import com.shopusa.server.dao.response.JwtAuthenticationResponse;
import com.shopusa.server.entity.Role;
import com.shopusa.server.entity.Usuario;
import com.shopusa.server.repository.UsuarioRepository;
import com.shopusa.server.service.AuthenticationService;
import com.shopusa.server.service.JwtService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {

        var user = Usuario.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .username(request.getUsername()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Credenciales incorrectas"));

        var jwt = jwtService.generateToken(user);

        // Crear un DTO con los datos del usuario
        var usuarioResponse = UsuarioResponseDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .role(user.getRole())
                .build();

        return JwtAuthenticationResponse.builder()
                .token(jwt)
                .usuario(usuarioResponse)
                .build();
    }
}
