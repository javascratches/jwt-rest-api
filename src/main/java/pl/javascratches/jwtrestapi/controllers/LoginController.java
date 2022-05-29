package pl.javascratches.jwtrestapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.javascratches.jwtrestapi.services.TokenService;
import pl.javascratches.jwtrestapi.model.LoginRequest;
import pl.javascratches.jwtrestapi.model.TokenResponse;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping
    public TokenResponse login(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword());
        authenticationManager.authenticate(authentication);

        return new TokenResponse(tokenService.generateToken(loginRequest.getUsername()));
    }

}
