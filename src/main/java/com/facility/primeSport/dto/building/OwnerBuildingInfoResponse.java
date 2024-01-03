package com.facility.primeSport.dto.building;

import com.facility.primeSport.dto.user.CoachDetailResponse;
import com.facility.primeSport.entitiy.Building;
import com.facility.primeSport.enums.permission.Role;

import java.util.List;
import java.util.stream.Collectors;

public class OwnerBuildingInfoResponse {


    private String buildingName;

    private String buildingUrl;

    private String instagramUrl;

    private String buildingWebUrl;

    private String facebookUrl;

    private String XUrl;

    private Double longitude;

    private Double latitude;

    private String buildingPhoneNumberSecond;

    private String buildingPhoneNumber;

    private String buildingDescription;

    private String buildingLogoUrl;

    private List<CoachDetailResponse> admins;

    private List<CoachDetailResponse> coaches;

    public OwnerBuildingInfoResponse(Building building) {
        this.buildingName = building.getBuildingName();
        this.buildingLogoUrl = building.getBuildingLogoUrl();
        this.buildingDescription = building.getBuildingDescription();
        this.facebookUrl = building.getFacebookUrl();
        this.instagramUrl = building.getInstagramUrl();
        this.XUrl = building.getXUrl();
        this.longitude = building.getLongitude();
        this.latitude = building.getLatitude();
        this.buildingPhoneNumber = building.getBuildingPhoneNumber();
        this.admins = building.getUsers()
                .stream()
                .filter(user -> user.getRole().equals(Role.B_OWNER))
                .map(CoachDetailResponse::new)
                .collect(Collectors.toList());
        this.coaches = building.getUsers().stream()
                .filter(user -> user.getRole().equals(Role.B_COACH))
                .map(CoachDetailResponse::new)
                .collect(Collectors.toList());
        this.buildingPhoneNumberSecond = building.getBuildingPhoneNumberSecond();
    }

    public List<CoachDetailResponse> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<CoachDetailResponse> coaches) {
        this.coaches = coaches;
    }

    public List<CoachDetailResponse> getAdmins() {
        return admins;
    }

    public void setUsers(List<CoachDetailResponse> admins) {
        this.admins = admins;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingUrl() {
        return buildingUrl;
    }

    public void setBuildingUrl(String buildingUrl) {
        this.buildingUrl = buildingUrl;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public String getBuildingWebUrl() {
        return buildingWebUrl;
    }

    public void setBuildingWebUrl(String buildingWebUrl) {
        this.buildingWebUrl = buildingWebUrl;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getXUrl() {
        return XUrl;
    }

    public void setXUrl(String XUrl) {
        this.XUrl = XUrl;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getBuildingPhoneNumberSecond() {
        return buildingPhoneNumberSecond;
    }

    public void setBuildingPhoneNumberSecond(String buildingPhoneNumberSecond) {
        this.buildingPhoneNumberSecond = buildingPhoneNumberSecond;
    }

    public String getBuildingPhoneNumber() {
        return buildingPhoneNumber;
    }

    public void setBuildingPhoneNumber(String buildingPhoneNumber) {
        this.buildingPhoneNumber = buildingPhoneNumber;
    }

    public String getBuildingDescription() {
        return buildingDescription;
    }

    public void setBuildingDescription(String buildingDescription) {
        this.buildingDescription = buildingDescription;
    }

    public String getBuildingLogoUrl() {
        return buildingLogoUrl;
    }

    public void setBuildingLogoUrl(String buildingLogoUrl) {
        this.buildingLogoUrl = buildingLogoUrl;
    }
}
