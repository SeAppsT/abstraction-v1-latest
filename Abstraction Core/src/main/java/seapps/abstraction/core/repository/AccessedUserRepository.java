package seapps.abstraction.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seapps.abstraction.core.domain.AccessedUser;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccessedUserRepository extends JpaRepository<AccessedUser, UUID> {
    Optional<AccessedUser> findByToken(String token);
}