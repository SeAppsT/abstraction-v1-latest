package seapps.abstraction.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seapps.abstraction.core.domain.Grant;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GrantRepository extends JpaRepository<Grant, Long> {
    Optional<Grant> findByNameAndComponent_IdAndUser_Id(String name, Long componentId, UUID userId);
}