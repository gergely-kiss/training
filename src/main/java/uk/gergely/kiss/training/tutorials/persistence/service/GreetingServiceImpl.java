package uk.gergely.kiss.training.tutorials.persistence.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gergely.kiss.training.tutorials.persistence.model.GreetingEntity;
import uk.gergely.kiss.training.tutorials.persistence.repository.GreetingEntityRepository;

import java.util.Collection;

@Service
public class GreetingServiceImpl implements GreetingService {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingServiceImpl.class);
    private final GreetingEntityRepository greetingEntityRepository;

    @Autowired
    public GreetingServiceImpl(GreetingEntityRepository greetingEntityRepository) {
        this.greetingEntityRepository = greetingEntityRepository;
    }

    @Override
    public Collection<GreetingEntity> findAll() {
        return greetingEntityRepository.findAll();
    }

    @Override
    public GreetingEntity findById(Long id){
        return greetingEntityRepository.findById(id).orElse(null);
    }

    @Override
    public GreetingEntity create(GreetingEntity greetingEntity) {
        LOG.info("create: greetingEntity {}", greetingEntity);
        if(greetingEntity.getId() == null){

            return greetingEntityRepository.save(greetingEntity);
        }
        return null;
       // return greetingEntity.getId() == null ?  greetingRepository.save(greetingEntity) : null;


    }

    @Override
    public GreetingEntity update(GreetingEntity greetingEntity)  {
        return  greetingEntityRepository.findById(greetingEntity.getId()).isPresent() ? greetingEntityRepository.save(greetingEntity): null;
    }

    @Override
    public void delete(Long id) {
        greetingEntityRepository.deleteById(id);
    }
}
