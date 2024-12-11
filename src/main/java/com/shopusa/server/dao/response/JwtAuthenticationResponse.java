package com.shopusa.server.dao.response;

import com.shopusa.server.dto.UsuarioResponse;
import com.shopusa.server.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponse {
    private String token;
    private UsuarioResponse usuario;
}
