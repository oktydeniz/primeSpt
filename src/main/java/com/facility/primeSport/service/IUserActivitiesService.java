package com.facility.primeSport.service;

import com.facility.primeSport.dto.chart.GraphResponse;

import java.util.List;

public interface IUserActivitiesService {

    List<GraphResponse> findBySteps();
}
