package seapps.abstraction.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seapps.abstraction.core.domain.Component;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {

}