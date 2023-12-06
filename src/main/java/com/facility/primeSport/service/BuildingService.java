package com.facility.primeSport.service;

import com.facility.primeSport.auth.JWTUserDetail;
import com.facility.primeSport.dto.building.BuildingRequest;
import com.facility.primeSport.dto.building.PackageRequest;
import com.facility.primeSport.dto.user.UpdateCoachRequest;
import com.facility.primeSport.entitiy.Building;
import com.facility.primeSport.entitiy.BuildingPackage;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.enums.permission.Role;
import com.facility.primeSport.model.ApiResponse;
import com.facility.primeSport.repo.BuildingPackageRepository;
import com.facility.primeSport.repo.BuildingRepository;
import com.facility.primeSport.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    private final UserRepository userRepository;

    private final BuildingPackageRepository buildingPackageRepository;

    public BuildingService(BuildingRepository repository, UserRepository userService, BuildingPackageRepository buildingPackageRepository) {
        this.buildingRepository = repository;
        this.userRepository = userService;
        this.buildingPackageRepository = buildingPackageRepository;
    }

    private Building createBuilding(Building building, Long userId){
        User user = userRepository.findById(userId).orElse(null);
        if (user != null){
            user.setRole(Role.B_OWNER);
            user.setAdmin(!user.isAdmin());
            building.getUsers().add(user);
            user.getBuildings().add(building);
            userRepository.save(user);
        }
        return buildingRepository.save(building);
    }

    public ResponseEntity<ApiResponse<Object>> createBuilding(Authentication authentication, BuildingRequest request){
        Building building = new Building(request);
        JWTUserDetail user = (JWTUserDetail) authentication.getPrincipal();
        User currentUser = userRepository.findById(user.getId()).orElse(null);
        if (currentUser != null){
            createBuilding(building, currentUser.getId());
            return new ResponseEntity<>(ApiResponse.success("Successfully Created"), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(ApiResponse.error(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ApiResponse<Object>> addUserToBuilding(Authentication authentication, UpdateCoachRequest request){
        Building building = buildingRepository.findById(request.buildingId()).orElse(null);
        User user = userRepository.findByEmail(request.userMail());
        if (user != null && building != null){
            user.setRole((request.role() != null ) ? request.role() : Role.B_USER);
            building.getUsers().add(user);
            user.getBuildings().add(building);
            user.setMemberStartDate(LocalDate.now());
            user.setMemberEndDate((request.endDate() != null) ? request.endDate() : null);

            buildingRepository.save(building);
            userRepository.save(user);
            return new ResponseEntity<>(ApiResponse.success("User Successfully Added"), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResponse.error(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ApiResponse<Set<Building>>> getBuilding(Authentication authentication) {
        JWTUserDetail user = (JWTUserDetail) authentication.getPrincipal();
        User owner = userRepository.findById(user.getId()).orElse(null);
        if (owner!=null){
            Set<Building> buildings = owner.getBuildings();
            return new ResponseEntity<>(ApiResponse.create(buildings), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResponse.error(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ApiResponse<Object>> deleteUser(Authentication authentication, UpdateCoachRequest request){
        User user = userRepository.findByEmail(request.userMail());
        Building building = buildingRepository.findById(request.buildingId()).orElse(null);
        if (building != null && user!= null){
            user.getBuildings().remove(building);
            building.getUsers().remove(user);
            user.setRole(Role.USER);
            buildingRepository.save(building);
            userRepository.save(user);
            return new ResponseEntity<>(ApiResponse.success("User Deleted"), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResponse.error(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ApiResponse<Object>> addPackage(Authentication authentication, PackageRequest request) {
        Building building = buildingRepository.findById(request.buildingId()).orElse(null);
        BuildingPackage buildingPackage = new BuildingPackage(request);
        if (building != null){
            buildingPackage.setBuilding(building);
            building.getPackages().add(buildingPackage);
            buildingRepository.save(building);
            buildingPackageRepository.save(buildingPackage);
            return new ResponseEntity<>(ApiResponse.success("Package Created!"), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(ApiResponse.error(), HttpStatus.BAD_REQUEST);
    }
}
