package uk.gergely.kiss.training.tutorials.tree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.gergely.kiss.training.tutorials.tree.model.NodeEntity;

public interface NodeEntityRepository extends JpaRepository<NodeEntity, Long> {
}
