package uk.gergely.kiss.training.tutorials.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.gergely.kiss.training.tutorials.persistence.model.RoleEntity;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
}
