package seapps.abstraction.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import seapps.abstraction.auth.domain.User;
import seapps.abstraction.auth.repository.UserRepository;
import seapps.abstraction.auth.security.SecurityUser;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByLogin(name);
        if (user.isEmpty())
            throw new UsernameNotFoundException("");
        return new SecurityUser(user.get());
    }
}