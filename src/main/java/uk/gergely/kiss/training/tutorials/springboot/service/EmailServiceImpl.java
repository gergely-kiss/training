package uk.gergely.kiss.training.tutorials.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import uk.gergely.kiss.training.tutorials.springboot.model.GreetingEntity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public Boolean send(GreetingEntity greetingEntity) {
        LOGGER.info("send: greetingEntity {}", greetingEntity);
        // simulate process execution time
        Boolean success = Boolean.FALSE;
        long pause = 5000;
        try {
            Thread.sleep(pause);
            success = Boolean.TRUE;
        } catch (Exception e) {
        }
        LOGGER.info("send: processing time was {} milliseconds ", pause);
        LOGGER.info("send: finished");

        return success;
    }

    // fire and forget because the initiating thread is not aware of the outcome of the async process
    @Async
    @Override
    public void sendAsync(GreetingEntity greetingEntity) {
        LOGGER.info("sendAsync: greetingEntity {}", greetingEntity);
        try {
            send(greetingEntity);
        } catch (Exception e) {
            LOGGER.info("sendAsync: exception caught sending email with greetingEntity {} , exception message: ", greetingEntity, e.getMessage());
        }
        LOGGER.info("sendAsync: finished");
    }

    @Async
    @Override
    public Future<Boolean> sendAsyncWithResult(GreetingEntity greetingEntity) {
        LOGGER.info("sendAsyncWithResult: greetingEntity {}", greetingEntity);
        CompletableFuture completableFutureResponse = new CompletableFuture();
        try {
            Boolean success = send(greetingEntity);
            completableFutureResponse.complete(success);
        } catch (Exception e) {
            LOGGER.info("sendAsyncWithResult: exception caught sending email with greetingEntity {} , exception message: ", greetingEntity, e.getMessage());
            completableFutureResponse.completeExceptionally(e);
        }
        LOGGER.info("sendAsyncWithResult: finished");
        return completableFutureResponse;
    }
}
