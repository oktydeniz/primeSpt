package com.facility.primeSport.dto.fitness;

public record CreateActivityRequest(
        String imageUrl,
        String name,
        String description,
        Integer workoutLevel,
        Boolean isPrivate,
        Long activityType

) {
}
