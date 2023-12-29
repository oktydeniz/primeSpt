package com.facility.primeSport.repo;

import com.facility.primeSport.entitiy.activity.PublicActivityWorkoutList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicActivityWorkoutRepository  extends JpaRepository<PublicActivityWorkoutList, Long> {}
