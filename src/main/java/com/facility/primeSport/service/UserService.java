package com.facility.primeSport.service;

import com.facility.primeSport.auth.JWTUserDetail;
import com.facility.primeSport.dto.user.PermissionData;
import com.facility.primeSport.dto.user.UserDetailResponse;
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

    public ResponseEntity<ApiResponse<UserDetailResponse>> getInfo(Authentication authentication) {

        JWTUserDetail userDetail = (JWTUserDetail) authentication.getPrincipal();
        if (userDetail != null){
            Optional<User> user = userRepository.findById(userDetail.getId());
            if (user.isPresent()){
                UserDetailResponse userDetailResponse = new UserDetailResponse(user.get());
                return new ResponseEntity<>(ApiResponse.create(userDetailResponse), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(ApiResponse.error(), HttpStatus.OK);
    }

    public UserDetailResponse getUserProfileInformation(Long userId){
        User user =userRepository.findById(userId).orElse(null);
        if (user != null){
            return new UserDetailResponse(user);
        }
        return null;
    }

    public Boolean updateUSerPermissions(PermissionData data, Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            switch (data.action()) {
                case "advertising" -> user.setIsActiveAdverting(data.isChecked());
                case "marketing" -> user.setIsActiveMarketing(data.isChecked());
                case "analytics" -> user.setIsActiveAnalytics(data.isChecked());
                default -> {
                }
            }
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public ResponseEntity<Boolean> updateLanguage(String language, Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setLanguage(language);
            userRepository.save(user);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
