package uk.gergely.kiss.training.tutorials.springboot.web.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.gergely.kiss.training.api.resources.ControllerConstants;
import uk.gergely.kiss.training.tutorials.springboot.model.GreetingEntity;
import uk.gergely.kiss.training.tutorials.springboot.service.EmailService;
import uk.gergely.kiss.training.tutorials.springboot.service.GreetingService;

import java.util.Collection;
import java.util.concurrent.Future;

@RestController
@RequestMapping(ControllerConstants.API_ROOT +
        ControllerConstants.TUTORIAL_PATH +
        ControllerConstants.PERSISTENCE_PATH +
        ControllerConstants.GREETING_PATH)
public class GreetingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);
    private final GreetingService greetingService;
    private final EmailService emailService;

    @Autowired
    public GreetingController(GreetingService greetingService, EmailService emailService) {
        this.greetingService = greetingService;
        this.emailService = emailService;
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

    @PostMapping(value = ControllerConstants.SLASH_ID + ControllerConstants.SEND_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GreetingEntity> sendGreeting(@PathVariable Long id, @RequestParam(value = "wait", defaultValue = "false") boolean waitForAsyncResult) {
          LOGGER.info("sendGreeting: id {} , waitForAsyncResult {}", id, waitForAsyncResult);
          GreetingEntity greetingEntity = null;
          try{
              greetingEntity = greetingService.findById(id);
              if(greetingEntity == null){
                  LOGGER.info("sendGreeting finished");
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
              }
              if(waitForAsyncResult){
                  Future<Boolean> asyncRepsonse = emailService.sendAsyncWithResult(greetingEntity);
                  LOGGER.info("sendGreeting: greeting email sent? {}", asyncRepsonse.get());
              }else{
                  emailService.sendAsync(greetingEntity);
              }

          }catch (Exception e){
              LOGGER.error("A problem occurred sending the greeting.",e);
              return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
          }
        LOGGER.info("sendGreeting finished");
        return new ResponseEntity<>(greetingEntity, HttpStatus.OK);
    }
}
