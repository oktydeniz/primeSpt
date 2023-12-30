package com.facility.primeSport.repo;

import com.facility.primeSport.entitiy.activity.PublicActivityWorkoutList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicActivityWorkoutRepository  extends JpaRepository<PublicActivityWorkoutList, Long> {
    @Query(value = "select * from psf_public_activity_workout_list WHERE is_deleted = false AND is_private = false limit 60", nativeQuery = true)
    @Modifying
    List<PublicActivityWorkoutList> findAllLists();

    List<PublicActivityWorkoutList> findByActivityTypeId(Long id);
}
