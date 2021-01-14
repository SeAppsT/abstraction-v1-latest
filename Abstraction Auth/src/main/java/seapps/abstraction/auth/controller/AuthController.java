package seapps.abstraction.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seapps.abstraction.auth.dto.AuthRequest;
import seapps.abstraction.auth.dto.AuthResponse;
import seapps.abstraction.auth.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest){
        return authService.login(authRequest);
    }
}