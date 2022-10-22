package org.wildfly.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wildfly.HelloWorld;

@RestController
@Slf4j
public class MainController {

    private final HelloWorld helloWorld;

    public MainController(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    @GetMapping("/")
    ResponseEntity<String> hello() {
        log.error("hello5");
        return ResponseEntity.ok(helloWorld.returnSmth());
    }


}
