package seapps.abstraction.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seapps.abstraction.core.domain.Cell;

@Repository
public interface CellRepository extends JpaRepository<Cell, Long> {

}