package com.facility.primeSport.service;

import com.facility.primeSport.auth.JWTUserDetail;
import com.facility.primeSport.dto.building.*;
import com.facility.primeSport.dto.user.UpdateCoachRequest;
import com.facility.primeSport.dto.user.UserPackagesList;
import com.facility.primeSport.entitiy.Building;
import com.facility.primeSport.entitiy.BuildingPackage;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.entitiy.UserSportDetail;
import com.facility.primeSport.enums.permission.Role;
import com.facility.primeSport.model.ApiResponse;
import com.facility.primeSport.repo.BuildingPackageRepository;
import com.facility.primeSport.repo.BuildingRepository;
import com.facility.primeSport.repo.UserRepository;
import com.facility.primeSport.repo.UserSportDetailRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    private final UserRepository userRepository;

    private final BuildingPackageRepository buildingPackageRepository;

    private final UserSportDetailRepository userSportDetailRepository;

    public BuildingService(BuildingRepository repository, UserRepository userService, BuildingPackageRepository buildingPackageRepository, UserSportDetailRepository userSportDetailRepository) {
        this.buildingRepository = repository;
        this.userRepository = userService;
        this.buildingPackageRepository = buildingPackageRepository;
        this.userSportDetailRepository = userSportDetailRepository;
    }

    private void createBuilding(Building building, Long userId){
        User user = userRepository.findById(userId).orElse(null);
        if (user != null){
            user.setRole(Role.B_OWNER);
            user.setAdmin(!user.isAdmin());
            building.getUsers().add(user);
            user.getBuildings().add(building);
            userRepository.save(user);
            buildingRepository.save(building);
        }
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
        User user = userRepository.findById(request.userId()).orElse(null);
        if (user != null && building != null){
            user.setRole((request.role() != null ) ? request.role() : Role.B_COACH);
            building.getUsers().add(user);
            user.getBuildings().add(building);
            buildingRepository.save(building);
            userRepository.save(user);
            return new ResponseEntity<>(ApiResponse.success("User Successfully Added"), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResponse.error(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ApiResponse<List<OwnerBuildingInfoResponse>>> getBuilding(Authentication authentication) {
        JWTUserDetail user = (JWTUserDetail) authentication.getPrincipal();
        User owner = userRepository.findById(user.getId()).orElse(null);
        if (owner!=null){
            Set<Building> buildings = owner.getBuildings();
            List<OwnerBuildingInfoResponse> buildingInfo = buildings.stream().map(OwnerBuildingInfoResponse::new).collect(Collectors.toList());
            return new ResponseEntity<>(ApiResponse.create(buildingInfo), HttpStatus.OK);
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

    public ResponseEntity<ApiResponse<Object>> addNewMember(Authentication authentication, UpdateCoachRequest request) {
        Building building = buildingRepository.findById(request.buildingId()).orElse(null);
        User user = userRepository.findById(request.userId()).orElse(null);
        BuildingPackage buildingPackage = buildingPackageRepository.findById(request.packageId()).orElse(null);
        User coach = userRepository.findById(request.coachId()).orElse(null);
        if (user != null && building != null && buildingPackage != null && coach != null){
            UserSportDetail userSportDetail = new UserSportDetail(building,buildingPackage,user, coach);
            userSportDetailRepository.save(userSportDetail);
            return new ResponseEntity<>(ApiResponse.success("User Successfully Added To Building"), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResponse.error(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ApiResponse<List<BuildingMembersResponse>>> getBuildingMembers(Long buildingId){
        List<UserSportDetail> users = userSportDetailRepository.getUsersByBuildingId(buildingId);
        if (users != null){
            List<BuildingMembersResponse> responses = users.stream().map(BuildingMembersResponse::new).collect(Collectors.toList());
            return new ResponseEntity<>(ApiResponse.create(responses), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResponse.error(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ApiResponse<Map<String , Object>>> getMemberDetail(Long userId){
        List<UserSportDetail> user = userSportDetailRepository.findByUserId(userId);
        if (user != null){
            List<BuildingMemberDetailResponse> data = user.stream().map(BuildingMemberDetailResponse::new).collect(Collectors.toList());
            Map<String , Object> response = groupTheUserPackages(data);
            return new ResponseEntity<>(ApiResponse.create(response), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResponse.error(), HttpStatus.BAD_REQUEST);
    }

    private Map<String , Object> groupTheUserPackages(List<BuildingMemberDetailResponse> response) {
        List<UserPackagesList> list = new ArrayList<>();
        Map<String , Object> userInformation = new HashMap<>();
        BuildingMemberDetailResponse data = response.get(0);
        userInformation.put("userName", data.getUserName());
        userInformation.put("phoneNumber", data.getPhoneNumber());
        userInformation.put("userAvatar", data.getUserAvatar());
        userInformation.put("userId", data.getUserId());
        userInformation.put("level", data.getLevel());
        for (BuildingMemberDetailResponse r : response) {
            UserPackagesList userPackagesList = new UserPackagesList(r);
            list.add(userPackagesList);
        }
        userInformation.put("packages", list);

        return userInformation;
    }
}
