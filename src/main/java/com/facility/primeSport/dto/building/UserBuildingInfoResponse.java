package com.facility.primeSport.dto.building;

import com.facility.primeSport.entitiy.Building;

public class UserBuildingInfoResponse {
    private String buildingName;
    private String buildingLogoUrl;

    public UserBuildingInfoResponse(Building building){
        this.buildingName = building.getBuildingName();
        this.buildingLogoUrl = building.getBuildingLogoUrl();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingLogoUrl() {
        return buildingLogoUrl;
    }

    public void setBuildingLogoUrl(String buildingLogoUrl) {
        this.buildingLogoUrl = buildingLogoUrl;
    }
}
