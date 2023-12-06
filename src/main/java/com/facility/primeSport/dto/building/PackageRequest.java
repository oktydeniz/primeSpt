package com.facility.primeSport.dto.building;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PackageRequest(
        String packageName,
        BigDecimal price,
        String description,
        String packageUrl,
        LocalDate endDate,
        Integer discountRate,
        Long buildingId
){

}
