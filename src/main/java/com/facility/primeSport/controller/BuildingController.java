package com.facility.primeSport.controller;

import com.facility.primeSport.dto.building.BuildingMembersResponse;
import com.facility.primeSport.dto.building.BuildingRequest;
import com.facility.primeSport.dto.building.OwnerBuildingInfoResponse;
import com.facility.primeSport.dto.building.PackageRequest;
import com.facility.primeSport.dto.user.UpdateCoachRequest;
import com.facility.primeSport.model.ApiResponse;
import com.facility.primeSport.service.BuildingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/building")
public class BuildingController {

    private final BuildingService service;

    public BuildingController(BuildingService service) {
        this.service = service;
    }


    @PostMapping
    @PreAuthorize("hasAuthority('user:crud') or hasAuthority('admin:crud')")
    public ResponseEntity<ApiResponse<Object>> save(Authentication authentication,
                                       @RequestBody BuildingRequest request,
                                       HttpServletRequest httpServletRequest){
        return service.createBuilding(authentication, request);
    }

    @PostMapping("/addCoach")
    @PreAuthorize("hasAuthority('admin:crud')")
    public ResponseEntity<ApiResponse<Object>> addNewCoach(Authentication authentication,
                                              @RequestBody UpdateCoachRequest request,
                                              HttpServletRequest httpServletRequest){
        return service.addUserToBuilding(authentication, request);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:crud')")
    public ResponseEntity<ApiResponse<List<OwnerBuildingInfoResponse>>> getBuilding(Authentication authentication,
                                                                                    HttpServletRequest request){
        return service.getBuilding(authentication);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:crud')")
    public ResponseEntity<ApiResponse<Object>> deleteUser(Authentication authentication,
                                                          @RequestBody UpdateCoachRequest request,
                                                          HttpServletRequest httpServletRequest){
        return service.deleteUser(authentication,request);
    }

    @PostMapping("/addPackage")
    @PreAuthorize("hasAuthority('admin:crud') or hasAuthority('user:crud')")
    public ResponseEntity<ApiResponse<Object>> addPackage(Authentication authentication,
                                                    @RequestBody PackageRequest request,
                                                    HttpServletRequest httpServletRequest){
        return service.addPackage(authentication, request);
    }

    @PostMapping("/addMember")
    @PreAuthorize("hasAuthority('admin:crud') or hasAuthority('coach:crud')")
    public ResponseEntity<ApiResponse<Object>> addNewMember(Authentication authentication,
                                                           @RequestBody UpdateCoachRequest request,
                                                           HttpServletRequest httpServletRequest){
        return service.addNewMember(authentication, request);
    }

    @GetMapping("/{building_id}")
    @PreAuthorize("hasAuthority('admin:crud') or hasAuthority('coach:crud')")
    public ResponseEntity<ApiResponse<List<BuildingMembersResponse>>> getBuildingMembers(Authentication authentication,
                                                                                         @PathVariable(name = "building_id") Long buildingId,
                                                                                         HttpServletRequest httpServletRequest){
        return service.getBuildingMembers(buildingId);

    }

    @GetMapping("users/{user_id}")
    @PreAuthorize("hasAuthority('admin:crud')")
    public ResponseEntity<ApiResponse<Map<String , Object>>> getMemberDetail(Authentication authentication,
                                                                             @PathVariable(name = "user_id") Long buildingId,
                                                                             HttpServletRequest httpServletRequest){
        return service.getMemberDetail(buildingId);
    }

}
