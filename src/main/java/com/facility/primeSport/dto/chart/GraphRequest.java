package com.facility.primeSport.dto.chart;

import java.time.LocalDate;

public record GraphRequest(
        String type,
        LocalDate startDate,
        LocalDate endDate,
        Long userId
) {
}
