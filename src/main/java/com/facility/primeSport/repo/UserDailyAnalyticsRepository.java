package com.facility.primeSport.repo;


import com.facility.primeSport.entitiy.analytics.UserDailyData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDailyAnalyticsRepository extends JpaRepository<UserDailyData, Long> {

    Optional<UserDailyData> findByUserId(Long userId);
}
