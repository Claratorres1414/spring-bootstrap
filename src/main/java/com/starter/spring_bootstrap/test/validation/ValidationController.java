package com.starter.spring_bootstrap.test.validation;

import com.starter.spring_bootstrap.shared.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/test"))
public class ValidationController {

    @PostMapping("/validation")
    public ResponseEntity<ApiResponse<ValidationRequest>> test(
            @Valid @RequestBody ValidationRequest request
    ) {
        return ResponseEntity.ok(
                ApiResponse.success(request, "Validation successful")
        );
    }

    @GetMapping("/test-error")
    public void testError() {
        throw new RuntimeException("Informação interna que não deve ser exposta");
    }
}
