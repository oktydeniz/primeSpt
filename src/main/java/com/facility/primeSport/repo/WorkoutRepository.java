package com.facility.primeSport.repo;

import com.facility.primeSport.entitiy.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    @Modifying
    @Query(value = "SELECT * FROM psf_workout pw " +
            "WHERE pw.workout_name ILIKE %:query% OR " +
            "pw.target_muscle ILIKE %:query% OR " +
            "pw.body_part ILIKE %:query%", nativeQuery = true)
    List<Workout> findByWorkoutName(String query);
}
