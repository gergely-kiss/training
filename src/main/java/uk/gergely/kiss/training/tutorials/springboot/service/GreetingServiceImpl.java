package uk.gergely.kiss.training.tutorials.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import uk.gergely.kiss.training.tutorials.springboot.model.GreetingEntity;
import uk.gergely.kiss.training.tutorials.springboot.repository.GreetingEntityRepository;

import java.util.Collection;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GreetingServiceImpl implements GreetingService {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingServiceImpl.class);
    private final GreetingEntityRepository greetingEntityRepository;

    @Autowired
    public GreetingServiceImpl(GreetingEntityRepository greetingEntityRepository) {
        this.greetingEntityRepository = greetingEntityRepository;
    }

    @Override
    public Collection<GreetingEntity> findAll() {
        LOG.info("findAll");
        return greetingEntityRepository.findAll();
    }

    @Override
    @Cacheable(value = "greetingEntitys", key = "#id")
    public GreetingEntity findById(Long id) {
        LOG.info("findById {}", id);
        return greetingEntityRepository.findById(id).orElse(null);
    }

    @Override
    @CachePut(value = "greetingEntitys", key = "#result.id")
    public GreetingEntity create(GreetingEntity greetingEntity) {
        LOG.info("create {}", greetingEntity);
        return greetingEntity.getId() == null ? greetingEntityRepository.save(greetingEntity) : null;
    }

    @Override
    @CachePut(value = "greetingEntitys", key = "#greetingEntity.id")
    public GreetingEntity update(GreetingEntity greetingEntity) {
        LOG.info("update {}", greetingEntity);
        return greetingEntityRepository.findById(greetingEntity.getId()).isPresent() ? greetingEntityRepository.save(greetingEntity) : null;
    }

    @Override
    @CacheEvict(value = "greetingEntitys", key = "#id")
    public void delete(Long id) {
        LOG.info("delete id {}", id);
        greetingEntityRepository.deleteById(id);
    }

    @Override
    @CacheEvict(value = "greetingEntitys", allEntries = true)
    public void evictCache() {
        LOG.info("evictCache");
    }
}
