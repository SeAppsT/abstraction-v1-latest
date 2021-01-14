package seapps.abstraction.core.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import seapps.abstraction.core.domain.AccessedUser;
import seapps.abstraction.core.repository.AccessedUserRepository;
import seapps.abstraction.core.repository.GrantRepository;

import java.util.Optional;

@Component
@Getter
@Setter
@RequiredArgsConstructor
public class SecurityManager {
    private final GrantRepository grantRepository;
    private final AccessedUserRepository userRepository;
    private AccessedUser user;

    public Boolean checkGrant(String grant, Long componentId){
        return grantRepository.findByNameAndComponent_IdAndUser_Id(grant, componentId, user.getId()).isPresent();
    }

    public Boolean authenticate(String token){
        Optional<AccessedUser> accessedUser = userRepository.findByToken(token);
        if (accessedUser.isPresent()) {
            this.setUser(accessedUser.get());
            return true;
        } else
            return false;
    }
}