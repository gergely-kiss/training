package uk.gergely.kiss.training.tutorials.springboot.service;

import uk.gergely.kiss.training.tutorials.springboot.model.GreetingEntity;

import java.util.concurrent.Future;

public interface EmailService {

    Boolean send (GreetingEntity greetingEntity);
    void sendAsync(GreetingEntity greetingEntity);
    Future<Boolean> sendAsyncWithResult(GreetingEntity greetingEntity);
}
