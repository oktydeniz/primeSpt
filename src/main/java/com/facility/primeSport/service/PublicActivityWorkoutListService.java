package com.facility.primeSport.service;

import com.facility.primeSport.dto.fitness.PublicActivityWorkoutResponse;
import com.facility.primeSport.entitiy.activity.PublicActivityWorkoutList;
import com.facility.primeSport.entitiy.fitness.ActivityType;
import com.facility.primeSport.repo.PublicActivityWorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PublicActivityWorkoutListService {

    private final PublicActivityWorkoutRepository repository;


    public PublicActivityWorkoutListService(PublicActivityWorkoutRepository repository) {
        this.repository = repository;
    }

    public Map<ActivityType, List<PublicActivityWorkoutResponse>> getGroupingActivities() {
        List<PublicActivityWorkoutList> entities = repository.findAllLists();
        return groupByActivity(entities);
    }


    public List<PublicActivityWorkoutResponse> getByCategoryId(Long id){
        List<PublicActivityWorkoutList> workoutLists = repository.findByActivityTypeId(id);
        return workoutLists.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private PublicActivityWorkoutResponse convertToDTO(PublicActivityWorkoutList entity) {
        return new PublicActivityWorkoutResponse(entity);
    }

    private Map<ActivityType, List<PublicActivityWorkoutResponse>>  groupByActivity(List<PublicActivityWorkoutList> workoutLists ) {
        return workoutLists.stream()
                .map(this::convertToDTO)
                .collect(Collectors.groupingBy(PublicActivityWorkoutResponse::getActivityType));
    }
}
