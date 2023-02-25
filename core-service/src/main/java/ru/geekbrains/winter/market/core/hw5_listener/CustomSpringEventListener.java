package ru.geekbrains.winter.market.core.hw5_listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


//Листенер с кодом ТУДУ...
@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {
    @Override
    public void onApplicationEvent(CustomSpringEvent event) {
        //Кладём спать - для тестов..
        Long seconds = 5000L;
        try {
            Thread.sleep(seconds);
            System.out.println("Received spring custom async event - " + event.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
