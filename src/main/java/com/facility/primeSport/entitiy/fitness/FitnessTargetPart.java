package com.facility.primeSport.entitiy.fitness;


import com.facility.primeSport.dto.fitness.MuscleTarget;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "fitness_target_muscle")
public class FitnessTargetPart extends DateIDBaseModel {

    @Column(name = "target_name", length = 85)
    private String targetName;

    @Column(name = "img")
    private String image;

    @Column(name = "description", length = 100)
    private String description;

    public FitnessTargetPart(String targetName, String image, String description) {
        this.targetName = targetName;
        this.image = image;
        this.description = description;
    }

    public FitnessTargetPart() {
    }

    public FitnessTargetPart(MuscleTarget target){
        this.targetName = target.name();
        this.image = target.image();
        this.description = target.description();
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

/*

    ABS, QUADS, LATS, CALVES, PECTORALS, GLUTES, HAMSTRINGS,
    ADDUCTORS, TRICEPS, CARDIOVASCULAR_SYSTEM, SPINE, UPPER_BACK,
    BICEPS, DELTS, FOREARMS, TRAPS, SERRATUS_ANTERIOR,
    ABDUCTORS, LEVATOR_SCAPULAE

 */