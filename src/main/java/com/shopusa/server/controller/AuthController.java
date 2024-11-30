package com.shopusa.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.shopusa.server.dao.request.SignInRequest;
import com.shopusa.server.dao.request.SignUpRequest;
import com.shopusa.server.dao.response.JwtAuthenticationResponse;
import com.shopusa.server.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
