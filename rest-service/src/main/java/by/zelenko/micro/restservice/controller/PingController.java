package by.zelenko.micro.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
public class PingController {

    @Autowired
    private Environment environment;

    @GetMapping("/ping")
    public String ping() {
        return String.format("- pong! <h1>%s</h1><p>Server time: %s",
                environment.getProperty("spring.application.name"), ZonedDateTime.now());
    }
}
