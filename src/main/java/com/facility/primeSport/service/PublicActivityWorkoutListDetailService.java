package com.facility.primeSport.service;

import com.facility.primeSport.dto.fitness.PublicActivityWorkoutListDetailResponse;
import com.facility.primeSport.entitiy.activity.PublicActivityWorkoutListDetail;
import com.facility.primeSport.enums.ActivityGroupType;
import com.facility.primeSport.repo.PublicActivityWorkoutListDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class PublicActivityWorkoutListDetailService {

    private final PublicActivityWorkoutListDetailRepository repository;

    public PublicActivityWorkoutListDetailService(PublicActivityWorkoutListDetailRepository service) {
        this.repository = service;
    }

    public Map<ActivityGroupType, List<PublicActivityWorkoutListDetailResponse>> findById(Long programId) {
        List<PublicActivityWorkoutListDetail> data = repository.findByProgramId(programId);
        return data.stream().map(this::convertToDTO)
                .collect(Collectors.groupingBy(PublicActivityWorkoutListDetailResponse::getType, TreeMap::new, Collectors.toList()
                ));
    }

    private PublicActivityWorkoutListDetailResponse convertToDTO(PublicActivityWorkoutListDetail entity) {
        return new PublicActivityWorkoutListDetailResponse(entity);
    }
}
