package ru.geekbrains.winter.market.core.hw5_listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


//Публицист ивента
@Component
public class CustomSpringEventPublisher {
    @Autowired
    //встроенный функциональный интерфейс
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String message) {
        System.out.println("publishCustomEvent()");
        CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}