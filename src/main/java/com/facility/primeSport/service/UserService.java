package com.facility.primeSport.service;

import com.facility.primeSport.auth.JWTUserDetail;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.model.ApiResponse;
import com.facility.primeSport.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUserId(Long id) {
         return userRepository.findById(id).orElse(null);
    }

    public ResponseEntity<ApiResponse<Object>> getInfo(Authentication authentication) {

        JWTUserDetail userDetail = (JWTUserDetail) authentication.getPrincipal();
        if (userDetail != null){
            Optional<User> user = userRepository.findById(userDetail.getId());
            if (user.isPresent()){
                return new ResponseEntity<>(ApiResponse.create(user.get().getEmail()), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(ApiResponse.error(), HttpStatus.OK);
    }
}
