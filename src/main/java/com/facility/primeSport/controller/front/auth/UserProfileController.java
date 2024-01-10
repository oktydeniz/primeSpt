package com.facility.primeSport.controller.front.auth;

import com.facility.primeSport.dto.fitness.PublicActivityListRequest;
import com.facility.primeSport.dto.fitness.PublicActivityWorkoutListDetailResponse;
import com.facility.primeSport.dto.fitness.PublicActivityWorkoutResponse;
import com.facility.primeSport.enums.ActivityGroupType;
import com.facility.primeSport.service.CollectionData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/profile")
public class UserProfileController {

    private CollectionData collectionData;


    public UserProfileController(CollectionData collectionData) {
        this.collectionData = collectionData;
    }

    @GetMapping
    public String profile(Authentication authentication, HttpServletRequest request, Model model) {
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }
        model.addAttribute("activities", collectionData.getActivityTypes());
        return "profile/profile";
    }

    @GetMapping("/program/{programId}")
    public String program(Authentication authentication, HttpServletRequest request, Model model,
                          @PathVariable(name = "programId") Long programId) {
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }
        model.addAttribute("activity", collectionData.getPublicProgramDetail(programId));
        model.addAttribute("activities", collectionData.getActivityTypes());
        model.addAttribute("workouts", collectionData.getAllWorkouts());

        Map<ActivityGroupType, List<PublicActivityWorkoutListDetailResponse>> listMap = collectionData.getPublicProgramListDetail(programId);
        if (listMap.get(ActivityGroupType.EXERCISE) != null) {
            model.addAttribute("exercise", listMap.get(ActivityGroupType.EXERCISE));
        }
        if (listMap.get(ActivityGroupType.COOL_DOWN) != null) {
            model.addAttribute("coolDown", listMap.get(ActivityGroupType.COOL_DOWN));
        }
        if (listMap.get(ActivityGroupType.WARM_UP) != null) {
            model.addAttribute("warmUp", listMap.get(ActivityGroupType.WARM_UP));
        }
        return "profile/program_create";
    }

    @PostMapping("/program/update")
    @ResponseBody
    public ResponseEntity<Boolean> updateActivityList(Authentication authentication, @RequestBody PublicActivityListRequest response) {
        boolean result = collectionData.updateActivityList(response);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
