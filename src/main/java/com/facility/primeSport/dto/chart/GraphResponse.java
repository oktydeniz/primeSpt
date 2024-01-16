package com.facility.primeSport.dto.chart;

import java.time.LocalDate;

public class GraphResponse {
    private Integer type;
    private LocalDate snapshotDate;


    public GraphResponse(LocalDate snapshotDate, Integer steps) {
        this.type = steps;
        this.snapshotDate = snapshotDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public LocalDate getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(LocalDate snapshotDate) {
        this.snapshotDate = snapshotDate;
    }
}
