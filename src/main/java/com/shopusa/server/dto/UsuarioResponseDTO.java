package com.shopusa.server.dto;

import com.shopusa.server.entity.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponseDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private Role role;
}
