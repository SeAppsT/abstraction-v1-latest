package seapps.abstraction.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import seapps.abstraction.auth.domain.User;
import seapps.abstraction.auth.dto.AuthRequest;
import seapps.abstraction.auth.dto.AuthResponse;
import seapps.abstraction.auth.repository.UserRepository;
import seapps.abstraction.auth.service.AuthService;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager manager;
    private final UserRepository repository;

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        Authentication authentication = manager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword()));
        User user = repository.findByLogin(authentication.getName()).orElseThrow(EntityNotFoundException::new);
        return new AuthResponse(user);
    }
}