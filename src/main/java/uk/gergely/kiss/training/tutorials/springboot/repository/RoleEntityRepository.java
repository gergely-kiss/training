package uk.gergely.kiss.training.tutorials.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.gergely.kiss.training.tutorials.springboot.model.RoleEntity;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
}
