package com.facility.primeSport.service;

import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.repo.UserRepository;
import org.springframework.stereotype.Service;

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
}
