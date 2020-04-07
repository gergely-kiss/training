package uk.gergely.kiss.training.tutorials.springboot.service;

import uk.gergely.kiss.training.tutorials.springboot.model.GreetingEntity;

import java.util.Collection;

public interface GreetingService {

    Collection<GreetingEntity> findAll();
    GreetingEntity findById(Long id);
    GreetingEntity create(GreetingEntity greetingEntity);
    GreetingEntity update(GreetingEntity greetingEntity);
    void delete(Long id);
    void evictCache();

}
