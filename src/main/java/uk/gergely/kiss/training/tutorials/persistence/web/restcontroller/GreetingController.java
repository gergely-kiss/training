package uk.gergely.kiss.training.tutorials.persistence.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.gergely.kiss.training.api.resources.ControllerConstants;
import uk.gergely.kiss.training.tutorials.persistence.model.GreetingEntity;
import uk.gergely.kiss.training.tutorials.persistence.service.GreetingService;

import java.util.Collection;

@RestController
@RequestMapping(ControllerConstants.API_ROOT + ControllerConstants.PERSISTENCE_PATH)
public class GreetingController {


    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping(ControllerConstants.SLASH_ID)
    public ResponseEntity<GreetingEntity> getGreetingById(@PathVariable Long id){
        return new ResponseEntity<>(greetingService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<GreetingEntity>> getAllGreetings(){
        return new ResponseEntity<>(greetingService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GreetingEntity> addGreeting(@RequestBody GreetingEntity greetingEntity){
        return new ResponseEntity<>(greetingService.create(greetingEntity), HttpStatus.ACCEPTED);
    }

    @PutMapping(ControllerConstants.SLASH_ID)
    public  ResponseEntity<GreetingEntity> updateGreeting(@RequestBody GreetingEntity greetingEntity){
        return  new ResponseEntity<>(greetingService.update(greetingEntity), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(ControllerConstants.SLASH_ID)
    public  ResponseEntity<GreetingEntity> deleteGreeting(@PathVariable Long id){
        greetingService.delete(id);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
