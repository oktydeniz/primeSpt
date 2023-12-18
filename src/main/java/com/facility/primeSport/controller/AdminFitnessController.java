package com.facility.primeSport.controller;

import com.facility.primeSport.dto.fitness.MuscleTarget;
import com.facility.primeSport.service.FitnessService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/mng/body")
@PreAuthorize("hasRole('ADMIN')")
public class AdminFitnessController {

    private final FitnessService fitnessService;

    public AdminFitnessController(FitnessService fitnessService) {
        this.fitnessService = fitnessService;
    }


    @PostMapping("/muscle")
    public ResponseEntity.BodyBuilder saveMuscleTarget(Authentication authentication, @RequestBody MuscleTarget model){
        fitnessService.saveTargetPart(model);
        return ResponseEntity.ok();
    }

    @PutMapping("/muscle/{id}")
    public ResponseEntity.BodyBuilder updateMuscleTarget(Authentication authentication,
                                                          @RequestParam Long id,
                                                          @RequestBody MuscleTarget model){
        fitnessService.updateTargetPart(id,model);
        return ResponseEntity.ok();
    }

    @PostMapping
    public ResponseEntity.BodyBuilder saveBodyPart(Authentication authentication,
                                                    @RequestBody MuscleTarget model){
        fitnessService.saveBodyPart(model);
        return ResponseEntity.ok();
    }

    @PutMapping("/{id}")
    public ResponseEntity.BodyBuilder updateBodyPart(Authentication authentication,
                                                      @RequestParam Long id,
                                                      @RequestBody MuscleTarget model){
        fitnessService.updateBodyPart(id, model);
        return ResponseEntity.ok();
    }
}
