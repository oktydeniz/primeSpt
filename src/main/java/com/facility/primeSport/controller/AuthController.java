package com.facility.primeSport.controller;

import com.facility.primeSport.dto.user.UserAuthRegisterRequest;
import com.facility.primeSport.dto.user.UserRequest;
import com.facility.primeSport.dto.AuthResponse;
import com.facility.primeSport.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody UserRequest request){
        return authService.login(request);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserAuthRegisterRequest request) {
        return authService.register(request);
    }

}
