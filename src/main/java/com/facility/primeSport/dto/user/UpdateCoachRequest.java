package com.facility.primeSport.dto.user;

import com.facility.primeSport.enums.permission.Role;
import lombok.Data;

import java.time.LocalDate;

public record UpdateCoachRequest(

        Long userId,
        Long buildingId,
        String userMail,
        Role role,
        LocalDate endDate,
        Long packageId,
        Long coachId
) {
}
