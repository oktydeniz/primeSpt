package com.facility.primeSport.dto.fitness;

public record PublicActivityListRequest(
        String imageUrl,
        String description,
        String name,
        Long id,
        Long activity,
        Long workoutLevel,
        boolean isPrivate
) {
}
