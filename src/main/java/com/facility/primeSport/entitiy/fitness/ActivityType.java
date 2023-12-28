package com.facility.primeSport.entitiy.fitness;

import com.facility.primeSport.View;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "activity_type")
public class ActivityType extends DateIDBaseModel {

    @Column(name = "description")
    @JsonView(View.Public.class)
    private String description;

    @Column(name = "activity_type")
    @JsonView(View.Public.class)
    private String activityType;

    @Column(name = "is_deleted")
    @JsonView(View.Public.class)
    private Boolean isDeleted;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
