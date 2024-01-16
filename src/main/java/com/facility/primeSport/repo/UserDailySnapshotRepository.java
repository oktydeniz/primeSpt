package com.facility.primeSport.repo;

import com.facility.primeSport.dto.chart.GraphResponse;
import com.facility.primeSport.entitiy.analytics.UserDailySnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserDailySnapshotRepository extends JpaRepository<UserDailySnapshot, Long> {

    @Modifying
    @Query(value = "SELECT NEW com.facility.primeSport.dto.chart.GraphResponse(t.snapshotDate, t.steps) FROM psf_user_analytics_snapshot t " +
            "WHERE snapshot_date >= :startDate AND snapshot_date <= :endDate AND user_id = :userId")
    List<GraphResponse> findValuesByMount(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("userId") Long userId
    );
}