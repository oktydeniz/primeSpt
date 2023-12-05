package com.facility.primeSport.controller;

import com.facility.primeSport.dto.building.BuildingRequest;
import com.facility.primeSport.dto.user.UpdateCoachRequest;
import com.facility.primeSport.entitiy.Building;
import com.facility.primeSport.service.BuildingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/building")
public class BuildingController {

    private final BuildingService service;

    public BuildingController(BuildingService service) {
        this.service = service;
    }


    @PostMapping
    @PreAuthorize("hasAuthority('user:crud') or hasAuthority('admin:crud')")
    public ResponseEntity<String> save(Authentication authentication,
                                       @RequestBody BuildingRequest request,
                                       HttpServletRequest httpServletRequest){
        return service.createBuilding(authentication, request);
    }

    @PostMapping("/addNewUser")
    @PreAuthorize("hasAuthority('admin:crud')")
    public ResponseEntity<String> addNewCoach(Authentication authentication,
                                              @RequestBody UpdateCoachRequest request,
                                              HttpServletRequest httpServletRequest){
        return service.addUserToBuilding(authentication, request);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:crud')")
    public ResponseEntity<Set<Building>> getBuilding(Authentication authentication,
                                                     HttpServletRequest request){
        return service.getBuilding(authentication);
    }
}
