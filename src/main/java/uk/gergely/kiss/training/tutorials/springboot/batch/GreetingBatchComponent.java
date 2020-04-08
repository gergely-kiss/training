package uk.gergely.kiss.training.tutorials.springboot.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import uk.gergely.kiss.training.tutorials.springboot.service.GreetingService;

@Component
public class GreetingBatchComponent {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingBatchComponent.class);


    private final GreetingService greetingService;

    @Autowired
    public GreetingBatchComponent(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Scheduled(cron = "0,30 * * * * *") // run the job at 0 and 30 second mark of every minute of every hour of every day
    public void cronJob() {
        LOGGER.info("cronJob started");
        LOGGER.info("cronJob: there are {} greetings in the data store.", greetingService.findAll().size());
        LOGGER.info("cronJob finished");
    }

    @Scheduled(initialDelay = 5000, fixedRate = 15000) // start the job every fixedRate defined time
    public void fixedRateJobWithInitialDelay() {
        LOGGER.info("fixedRateJobWithInitialDelay started");
        long pause = 5000;
        long start = System.currentTimeMillis();
        do {
            if (start + pause < System.currentTimeMillis()) {
                break;
            }
        } while (true);
        LOGGER.info("fixedRateJobWithInitialDelay: processing time was {} seconds", System.currentTimeMillis() - start);
        LOGGER.info("fixedRateJobWithInitialDelay finished");
    }

    @Scheduled(initialDelay = 5000, fixedDelay = 15000) // starts the job every time after the previous job finished delayed with the fixed Delay time ergo at most one instance of the job is running in any given time
    public void fixedDelayJobWithInitialDelay() {
        LOGGER.info("fixedDelayJobWithInitialDelay started");
        long pause = 5000;
        long start = System.currentTimeMillis();
        do {
            if (start + pause < System.currentTimeMillis()) {
                break;
            }
        } while (true);
        LOGGER.info("fixedDelayJobWithInitialDelay: processing time was {} seconds", System.currentTimeMillis() - start);
        LOGGER.info("fixedDelayJobWithInitialDelay finished");
    }
}
