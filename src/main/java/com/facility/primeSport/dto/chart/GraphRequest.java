package com.facility.primeSport.dto.chart;

import java.time.LocalDate;

public record GraphRequest(
        String type,
        LocalDate today,
        LocalDate endDate,
        Long userId
) {
}
