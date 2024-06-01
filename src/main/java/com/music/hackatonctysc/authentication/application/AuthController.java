package com.music.hackatonctysc.authentication.application;

import com.music.hackatonctysc.authentication.DTO.AuthRequest;
import com.music.hackatonctysc.authentication.DTO.RegisterRequest;
import com.music.hackatonctysc.authentication.domain.AuthService;
import com.music.hackatonctysc.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        authService.registerUser(registerRequest);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AuthRequest authRequest) {
        User user = authService.loginUser(authRequest);
        return ResponseEntity.ok("Login successful");
    }
}
