package com.shopusa.server.service;

import com.shopusa.server.dao.request.SignInRequest;
import com.shopusa.server.dao.request.SignUpRequest;
import com.shopusa.server.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
