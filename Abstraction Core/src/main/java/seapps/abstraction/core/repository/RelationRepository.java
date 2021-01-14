package seapps.abstraction.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seapps.abstraction.core.domain.Relation;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Long> {

}