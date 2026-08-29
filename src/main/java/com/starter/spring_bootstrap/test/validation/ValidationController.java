package com.starter.spring_bootstrap.test.validation;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/test"))
public class ValidationController {

    @PostMapping("/validation")
    public ResponseEntity<Void> test(
            @Valid @RequestBody ValidationRequest request
    ) {
        return ResponseEntity.ok().build();
    }
}
