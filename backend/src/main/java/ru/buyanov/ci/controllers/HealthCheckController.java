package ru.buyanov.ci.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public class HealthCheckController {

    @RequestMapping("")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Feeling good today");
    }
}
