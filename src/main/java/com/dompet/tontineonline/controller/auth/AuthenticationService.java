package com.dompet.tontineonline.controller.auth;

import com.dompet.tontineonline.dto.AuthentificationDTO;
import com.dompet.tontineonline.repository.UserRepository;
import com.dompet.tontineonline.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    public  final AuthenticationManager authenticationManager;

    public  AuthenticationResponse authenticate(AuthentificationDTO authentificationDTO){
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.getUsername(), authentificationDTO.getPassword())
        );

        if(authenticate.isAuthenticated()) {
            var user = this.userRepository.findByEmail(authentificationDTO.getUsername())
                    .orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .build();
        }
        return null;

    }
}
