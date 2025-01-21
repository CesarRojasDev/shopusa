package com.shopusa.server.service.impl;

import com.shopusa.server.exeption.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.shopusa.server.repository.UsuarioRepository;
import com.shopusa.server.service.UsuarioService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsuarioService {

    private final UsuarioRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByUsername(username)
                        .orElseThrow(() -> new EntityNotFoundException("Usuario",username));
            }
        };
    }
}
