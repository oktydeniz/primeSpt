package com.facility.primeSport.controller;


import com.facility.primeSport.auth.JWTUserDetail;
import com.facility.primeSport.dto.user.UserDetailResponse;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.model.ApiResponse;
import com.facility.primeSport.repo.UserRepository;
import com.facility.primeSport.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<UserDetailResponse>> getInfo(Authentication authentication){
        return userService.getInfo(authentication);
    }
}
