package org.example.restapi.controller;

import java.util.Map;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.example.restapi.dto.response.ApiResponse;
import org.example.restapi.security.JwtProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jwt-test")
@RequiredArgsConstructor
public class JwtTestController {

    private final JwtProvider jwtProvider;

    @GetMapping("/generate")
    public ResponseEntity<ApiResponse<Map<String, String>>> generateToken(
        @RequestParam String username
    ) {
        String token = jwtProvider.createToken(username);
        return ResponseEntity.ok(ApiResponse.success(Map.of("token", token)));
    }


    @GetMapping("/validate")
    public ResponseEntity<ApiResponse<Map<String, Object>>> validateToken(
        @RequestParam String token
    ) {
        boolean valid = jwtProvider.validateToken(token);
        String username = valid ? jwtProvider.getUsername(token) : null;

        return ResponseEntity.ok(ApiResponse.success(
            Map.of(
                "valid", valid,
                "username", username
            )
        ));
    }

}

