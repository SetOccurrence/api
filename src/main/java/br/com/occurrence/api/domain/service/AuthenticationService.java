package br.com.occurrence.api.domain.service;

import br.com.occurrence.api.app.api.dto.auth.AuthenticationRequest;
import br.com.occurrence.api.app.api.dto.auth.AuthenticationResponse;
import br.com.occurrence.api.domain.model.organization.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserReadService userReadService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.login(), request.password()));
        User user = userReadService.findByLogin(request.login());
        String bearerToken = jwtService.generateToken(user);
        return new AuthenticationResponse(bearerToken);
    }

}
