package com.facility.primeSport.service;

import com.facility.primeSport.entitiy.activity.PublicActivityWorkoutListDetail;
import com.facility.primeSport.repo.PublicActivityWorkoutListDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicActivityWorkoutListDetailService {

    private final PublicActivityWorkoutListDetailRepository service;

    public PublicActivityWorkoutListDetailService(PublicActivityWorkoutListDetailRepository service) {
        this.service = service;
    }

    public List<PublicActivityWorkoutListDetail> findById(Long programId) {
        return service.findByProgramId(programId);
    }
}
