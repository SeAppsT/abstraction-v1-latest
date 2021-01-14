package seapps.abstraction.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seapps.abstraction.auth.domain.User;

import java.util.UUID;

@Getter
@Setter
public class AuthResponse {
    private UUID id;
    private String login;
    private String name;

    public AuthResponse(User user){
        id = user.getId();
        login = user.getLogin();
        name = user.getName();
    }
}