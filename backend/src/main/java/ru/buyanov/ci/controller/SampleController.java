package ru.buyanov.ci.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.buyanov.ci.repository.SampleRepository;

@RestController
@RequestMapping("samples")
@AllArgsConstructor
public class SampleController {
    private final SampleRepository repository;

    @RequestMapping("count")
    public ResponseEntity<Long> samplesCount() {
        return ResponseEntity.ok(repository.count());
    }
}
