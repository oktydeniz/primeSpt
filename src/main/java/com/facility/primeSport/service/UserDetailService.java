package com.facility.primeSport.service;

import com.facility.primeSport.auth.JWTUserDetail;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

   private final UserRepository repository;

    public UserDetailService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if (user != null) {
            return JWTUserDetail.create(user);
        }
        throw new UsernameNotFoundException(email);
    }

    public UserDetails loadUserById(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()){
            return JWTUserDetail.create(user.get());
        }
        throw new UsernameNotFoundException("User Not Found");
    }
}
