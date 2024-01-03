package com.facility.primeSport.repo;

import com.facility.primeSport.entitiy.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository  extends JpaRepository<Workout, Long> {

}
