package com.facility.primeSport.service;

import com.facility.primeSport.entitiy.analytics.UserDailyData;
import com.facility.primeSport.repo.UserDailyAnalyticsRepository;
import com.facility.primeSport.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UDailyAnalyticsService {

    private UserDailyAnalyticsRepository userDailyRepository;

    public UDailyAnalyticsService(UserDailyAnalyticsRepository userDailyRepository) {
        this.userDailyRepository = userDailyRepository;
    }

    public UserDailyData getDailyData(Long userId){
        Optional<UserDailyData> data = userDailyRepository.findByUserId(userId);
        return data.orElse(null);
    }
}
