package com.facility.primeSport.repo;

import com.facility.primeSport.entitiy.activity.PublicActivityWorkoutListDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicActivityWorkoutListDetailRepository extends JpaRepository<PublicActivityWorkoutListDetail, Long> {

    @Query(value = "select * from psf_public_activity_workout_list_detail where program_id = :programId order by workout_order asc", nativeQuery = true)
    @Modifying
    List<PublicActivityWorkoutListDetail> findByProgramId(Long programId);

}
