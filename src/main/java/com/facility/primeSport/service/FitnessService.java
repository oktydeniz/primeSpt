package com.facility.primeSport.service;

import com.facility.primeSport.dto.fitness.MuscleTarget;
import com.facility.primeSport.entitiy.fitness.FitnessBodyPart;
import com.facility.primeSport.entitiy.fitness.FitnessTargetPart;
import com.facility.primeSport.repo.FitnessBodyPartRepository;
import com.facility.primeSport.repo.FitnessTargetPartRepository;
import org.springframework.stereotype.Service;


@Service
public class FitnessService {

    private FitnessBodyPartRepository bodyPartRepository;

    private FitnessTargetPartRepository targetPartRepository;

    public FitnessService(FitnessBodyPartRepository bodyPartRepository,
                          FitnessTargetPartRepository targetPartRepository) {
        this.bodyPartRepository = bodyPartRepository;
        this.targetPartRepository = targetPartRepository;
    }

    public void saveBodyPart(MuscleTarget model){
        FitnessBodyPart data = new FitnessBodyPart(model);
        bodyPartRepository.save(data);
    }

    public void saveTargetPart(MuscleTarget model){
        FitnessTargetPart data = new FitnessTargetPart(model);
        targetPartRepository.save(data);
    }

    public void updateBodyPart(Long id, MuscleTarget model){
        FitnessBodyPart data = bodyPartRepository.findById(id).orElse(null);
        if (data != null){
            data.setBodyPart(model.name());
            data.setDescription(model.description());
            data.setImage(model.image());
            bodyPartRepository.save(data);
        }
    }

    public void updateTargetPart(Long id, MuscleTarget model){
        FitnessTargetPart data = targetPartRepository.findById(id).orElse(null);
        if (data != null){
            data.setTargetName(model.name());
            data.setDescription(model.description());
            data.setImage(model.image());
            targetPartRepository.save(data);
        }
    }
}
