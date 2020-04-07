package uk.gergely.kiss.training.tutorials.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.gergely.kiss.training.tutorials.springboot.model.GreetingEntity;

@Repository
public interface GreetingEntityRepository extends JpaRepository <GreetingEntity, Long> {

}
