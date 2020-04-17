package uk.gergely.kiss.training.tutorials.springboot.web.actuactor.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import uk.gergely.kiss.training.tutorials.springboot.model.GreetingEntity;
import uk.gergely.kiss.training.tutorials.springboot.service.GreetingService;

import java.util.Collection;

@Component
public class GreetingHealthIndicator implements HealthIndicator {


    private final GreetingService greetingService;

    @Autowired
    public GreetingHealthIndicator(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public Health getHealth(boolean includeDetails) {
        Collection<GreetingEntity> all = greetingService.findAll();
        if(all == null || all.size() == 0){
            return includeDetails? Health.down().withDetail("Count", 0).build(): Health.down().build();
        }
        return  includeDetails? Health.up().withDetail("Count", 0).build(): Health.up().build();
    }

    @Override
    public Health health() {
        Collection<GreetingEntity> all = greetingService.findAll();
        if(all == null || all.size() == 0){
            return Health.down().withDetail("Count", 0).build();
        }
        return Health.up().withDetail("Count", all.size()).build();
    }
}
