package br.com.alunoonline.api.dtos.security;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
