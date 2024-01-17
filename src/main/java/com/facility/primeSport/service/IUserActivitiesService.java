package com.facility.primeSport.service;

import com.facility.primeSport.dto.chart.GraphResponse;
import com.facility.primeSport.entitiy.analytics.UserDailySnapshot;

import java.util.List;

public interface IUserActivitiesService {

    List<GraphResponse> findBySteps(List<UserDailySnapshot> list);

    List<GraphResponse> findByCalories(List<UserDailySnapshot> list);
}
