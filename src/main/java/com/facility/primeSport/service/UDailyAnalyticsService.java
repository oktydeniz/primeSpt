package com.facility.primeSport.service;

import com.facility.primeSport.dto.user.UserDailyDataResponse;
import com.facility.primeSport.dto.user.UserDetailResponse;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.entitiy.analytics.UserDailyData;
import com.facility.primeSport.repo.UserDailyAnalyticsRepository;
import com.facility.primeSport.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UDailyAnalyticsService {

    private UserDailyAnalyticsRepository userDailyRepository;

    private UserRepository userRepository;

    public UDailyAnalyticsService(UserDailyAnalyticsRepository userDailyRepository, UserRepository userRepository) {
        this.userDailyRepository = userDailyRepository;
        this.userRepository = userRepository;
    }

    public UserDailyDataResponse getDailyData(Long userId){
        Optional<UserDailyData> data = userDailyRepository.findByUserId(userId);
        User user = userRepository.findById(userId).orElse(null);
        if (user != null && data.isPresent()){
            return new UserDailyDataResponse(data.get(), user);
        }
        return new UserDailyDataResponse();
    }
}
