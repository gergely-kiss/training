package uk.gergely.kiss.training.tutorials.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.gergely.kiss.training.tutorials.persistence.model.AccountEntity;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long> {
}
