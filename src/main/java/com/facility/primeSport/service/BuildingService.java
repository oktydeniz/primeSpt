package com.facility.primeSport.service;

import com.facility.primeSport.auth.JWTUserDetail;
import com.facility.primeSport.dto.building.BuildingRequest;
import com.facility.primeSport.dto.user.UpdateCoachRequest;
import com.facility.primeSport.entitiy.Building;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.enums.permission.Role;
import com.facility.primeSport.repo.BuildingRepository;
import com.facility.primeSport.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    private final UserRepository userRepository;

    public BuildingService(BuildingRepository repository, UserRepository userService) {
        this.buildingRepository = repository;
        this.userRepository = userService;
    }

    private Building createBuilding(Building building, Long userId){
        User user = userRepository.findById(userId).orElse(null);
        if (user != null){
            user.setRole(Role.B_OWNER);
            user.setAdmin(!user.isAdmin());
            building.getUsers().add(user);
            user.getBuildings().add(building);
        }
        return buildingRepository.save(building);
    }

    public ResponseEntity<String> createBuilding(Authentication authentication, BuildingRequest request){
        Building building = new Building(request);
        JWTUserDetail user = (JWTUserDetail) authentication.getPrincipal();
        User currentUser = userRepository.findById(user.getId()).orElse(null);
        if (currentUser != null){
            createBuilding(building, currentUser.getId());
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addUserToBuilding(Authentication authentication, UpdateCoachRequest request){
        addUserToBuilding(request.getBuildingId(), request.getCoachMail());
        return new ResponseEntity<>("User Added", HttpStatus.CREATED);
    }
    private void addUserToBuilding(Long buildingId, String  email){
        Building building = buildingRepository.findById(buildingId).orElse(null);
        User user = userRepository.findByEmail(email);
        if (user != null && building != null){
            user.setRole(Role.B_COACH);
            building.getUsers().add(user);
            user.getBuildings().add(building);
            buildingRepository.save(building);
            userRepository.save(user);
        }
    }

    public ResponseEntity<Set<Building>> getBuilding(Authentication authentication) {
        JWTUserDetail user = (JWTUserDetail) authentication.getPrincipal();
        User owner = userRepository.findById(user.getId()).orElse(null);
        if (owner!=null){
            Set<Building> buildings = owner.getBuildings();
            return new ResponseEntity<>(buildings, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
