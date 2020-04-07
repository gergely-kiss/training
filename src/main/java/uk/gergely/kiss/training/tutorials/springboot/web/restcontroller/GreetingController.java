package uk.gergely.kiss.training.tutorials.springboot.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.gergely.kiss.training.api.resources.ControllerConstants;
import uk.gergely.kiss.training.tutorials.springboot.model.GreetingEntity;
import uk.gergely.kiss.training.tutorials.springboot.service.GreetingService;

import java.util.Collection;

@RestController
@RequestMapping(ControllerConstants.API_ROOT +
        ControllerConstants.TUTORIAL_PATH +
        ControllerConstants.PERSISTENCE_PATH +
        ControllerConstants.GREETING_PATH)
public class GreetingController {


    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping(value = ControllerConstants.SLASH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GreetingEntity> getGreetingById(@PathVariable Long id) {
        return new ResponseEntity<>(greetingService.findById(id), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<GreetingEntity>> getAllGreetings() {
        return new ResponseEntity<>(greetingService.findAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GreetingEntity> addGreeting(@RequestBody GreetingEntity greetingEntity) {
        return new ResponseEntity<>(greetingService.create(greetingEntity), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GreetingEntity> updateGreeting(@RequestBody GreetingEntity greetingEntity) {
        return new ResponseEntity<>(greetingService.update(greetingEntity), HttpStatus.OK);
    }

    @DeleteMapping(value = ControllerConstants.SLASH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GreetingEntity> deleteGreeting(@PathVariable Long id) {
        greetingService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
