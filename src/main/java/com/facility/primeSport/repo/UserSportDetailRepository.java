package com.facility.primeSport.repo;

import com.facility.primeSport.entitiy.UserSportDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserSportDetailRepository extends JpaRepository<UserSportDetail, Long> {

    @Modifying
    @Query(value = "SELECT DISTINCT ON (user_id) * FROM psf_user_sport_detail WHERE building_id = :buildingId", nativeQuery = true)
    List<UserSportDetail> getUsersByBuildingId(Long buildingId);

    UserSportDetail findByUserId(Long userId);
}
