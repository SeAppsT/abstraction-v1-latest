package seapps.abstraction.auth.service;

import seapps.abstraction.auth.dto.AuthRequest;
import seapps.abstraction.auth.dto.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest authRequest);
}