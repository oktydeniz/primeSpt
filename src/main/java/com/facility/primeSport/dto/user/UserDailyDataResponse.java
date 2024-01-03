package com.facility.primeSport.dto.user;

import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.entitiy.analytics.UserDailyData;

import java.math.BigDecimal;

public class UserDailyDataResponse {

    private Integer calories;
    private Double distance;
    private Integer steps;
    private Integer sleepTime;
    private Double weight;
    private Double height;
    private Double bms;
    private BigDecimal bmsPer;
    private BigDecimal stressLevel;

    private User user;

    public UserDailyDataResponse() {
        this.calories = 0;
        this.distance = 0.0;
        this.steps = 0;
        this.sleepTime = 0;
        this.weight = 0.0;
        this.height = 0.0;
        this.bms = 0.0;
        this.stressLevel = BigDecimal.ZERO;
        this.bmsPer = BigDecimal.ZERO;
    }

    public UserDailyDataResponse(UserDailyData data, User user) {
        this.height = data.getHeight();
        this.weight = data.getWeight();
        this.steps = data.getSteps();
        this.calories = data.getCalories();
        this.bms = data.getBms();
        this.bmsPer = data.getBmsPer();
        this.sleepTime = getSleepTime(data.getSleepTime());
        this.stressLevel = data.getStressLevel();
        this.distance = data.getDistance();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private Integer getSleepTime(Integer sleepTime) {
        // this could be chance if data type came different integer
        return sleepTime;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Integer getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Integer sleepTime) {
        this.sleepTime = sleepTime;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getBms() {
        return bms;
    }

    public void setBms(Double bms) {
        this.bms = bms;
    }

    public BigDecimal getBmsPer() {
        return bmsPer;
    }

    public void setBmsPer(BigDecimal bmsPer) {
        this.bmsPer = bmsPer;
    }

    public BigDecimal getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(BigDecimal stressLevel) {
        this.stressLevel = stressLevel;
    }
}
