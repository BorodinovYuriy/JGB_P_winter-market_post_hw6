package ru.geekbrains.winter.market.core.hw5_listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/listener_test")
public class EventController {
    @Autowired
    private CustomSpringEventPublisher customEventPublisher;

    @GetMapping
    public String root(){
        System.out.println("Entered into controller.");
        customEventPublisher.publishCustomEvent("publishCustomEvent event is OK");
        System.out.println("Finished.");
        return "!!!!!!!!!!!Hello World!!!!!!!!!!!!!!!!!";
    }


}
