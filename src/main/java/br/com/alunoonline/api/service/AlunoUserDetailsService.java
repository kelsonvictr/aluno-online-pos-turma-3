package br.com.alunoonline.api.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AlunoUserDetailsService implements UserDetailsService {

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            if ("user".equals(username)) {
                return org.springframework.security.core.userdetails.User
                        .withUsername(username)
                        .password(new BCryptPasswordEncoder().encode("password")) // senha codificada com BCrypt
                        .authorities("ROLE_USER")
                        .build();
            } else {
                throw new UsernameNotFoundException("Usuário não encontrado");
            }
        }
    }