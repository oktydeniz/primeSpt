package com.facility.primeSport.service;


import com.facility.primeSport.dto.fitness.WorkoutResponse;
import com.facility.primeSport.entitiy.Workout;
import com.facility.primeSport.repo.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SearchService {


    private final WorkoutRepository repository;

    public SearchService(WorkoutRepository repository) {
        this.repository = repository;
    }

    public List<WorkoutResponse> searchForWorkoutName(String query) {
        List<Workout> response = repository.findByWorkoutName(query);
        if (response != null){
            return  response.stream().map(WorkoutResponse::new).collect(Collectors.toList());
        }
        return null;
    }
}
