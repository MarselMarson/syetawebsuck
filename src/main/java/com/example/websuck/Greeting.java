package com.example.websuck;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static java.lang.Thread.sleep;

@RestController
public class Greeting {
    private static boolean isAlive = false;
    private static final Thread thread = new Thread(() -> {
        isAlive = true;
        while (isAlive) {
            System.out.println("sss");
            try {
                sleep(25_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    });

    @GetMapping("/hi")
    String greeting() {
        return "hello, bitches!";
    }

    @GetMapping("/start_delay")
    boolean startDelay() {
        thread.start();
        return true;
    }

}
