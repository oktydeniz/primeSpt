package com.facility.primeSport.dto.chart;

import java.time.LocalDate;

public class GraphResponse {
    private Integer value;
    private LocalDate snapshotDate;


    public GraphResponse(LocalDate snapshotDate, Integer value) {
        this.value = value;
        this.snapshotDate = snapshotDate;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public LocalDate getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(LocalDate snapshotDate) {
        this.snapshotDate = snapshotDate;
    }
}
