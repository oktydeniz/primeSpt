package com.facility.primeSport.entitiy.fitness;

import com.facility.primeSport.dto.fitness.MuscleTarget;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "fitness_body_part")
public class FitnessBodyPart extends DateIDBaseModel {

    @Column(name = "body_part_name", length = 85)
    private String bodyPart;

    @Column(name = "img")
    private String image;

    @Column(name = "description", length = 100)
    private String description;


    public FitnessBodyPart(String bodyPart, String image, String description) {
        this.bodyPart = bodyPart;
        this.image = image;
        this.description = description;
    }

    public FitnessBodyPart() {
    }

    public FitnessBodyPart(MuscleTarget target){
        this.bodyPart = target.name();
        this.image = target.image();
        this.description = target.description();
    }
    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
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

    WAIST, UPPER_LEGS, BACK, LOWER_LEGS, CHEST, UPPER_ARMS,
    CARDIO, SHOULDERS, LOWER_ARMS, NECK
 */