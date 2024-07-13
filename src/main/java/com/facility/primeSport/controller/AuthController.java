package com.facility.primeSport.controller;

import com.facility.primeSport.dto.user.UpdateCoachRequest;
import com.facility.primeSport.dto.user.UserAuthRegisterRequest;
import com.facility.primeSport.dto.user.UserRequest;
import com.facility.primeSport.dto.AuthResponse;
import com.facility.primeSport.model.ApiResponse;
import com.facility.primeSport.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
