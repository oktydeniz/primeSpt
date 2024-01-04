package com.facility.primeSport.controller.front;

import com.facility.primeSport.auth.JWTUserDetail;
import com.facility.primeSport.dto.fitness.PublicActivityWorkoutListDetailResponse;
import com.facility.primeSport.dto.fitness.PublicActivityWorkoutResponse;
import com.facility.primeSport.dto.fitness.WorkoutResponse;
import com.facility.primeSport.dto.user.UserDailyDataResponse;
import com.facility.primeSport.entitiy.Workout;
import com.facility.primeSport.entitiy.fitness.ActivityType;
import com.facility.primeSport.enums.ActivityGroupType;
import com.facility.primeSport.service.CollectionData;
import com.facility.primeSport.service.UDailyAnalyticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final UDailyAnalyticsService dailyAnalyticsService;
    private final CollectionData collectionData;

    public HomeController(UDailyAnalyticsService dailyAnalyticsService, CollectionData collectionData) {
        this.dailyAnalyticsService = dailyAnalyticsService;
        this.collectionData = collectionData;
    }

    @GetMapping
    public String home(Model model) {
        return "index/m_index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }
        JWTUserDetail userDetail = (JWTUserDetail) authentication.getPrincipal();
        UserDailyDataResponse dailyData = dailyAnalyticsService.getDailyData(userDetail.getId());
        Map<ActivityType, List<PublicActivityWorkoutResponse>> activities = collectionData.getGroupingActivities();
        model.addAttribute("dailyData", dailyData);
        model.addAttribute("activities", activities);
        return "dashboard/dashboard";
    }


    @GetMapping("/dashboard/category/{categoryId}")
    public String getCategory(Model model, @PathVariable(name = "categoryId") Long categoryId,
                              Authentication authentication) {
        List<PublicActivityWorkoutResponse> category = collectionData.getByCategory(categoryId);
        ActivityType activity = collectionData.getActivityType(categoryId);
        model.addAttribute("category", category);
        model.addAttribute("activity", activity);
        return "dashboard/category";
    }

    @GetMapping("/dashboard/program/{programId}")
    public String getSelectedProgramDetail(Model model, @PathVariable(name = "programId") Long programId,
                                           Authentication authentication) {
        PublicActivityWorkoutResponse program = collectionData.getPublicProgramDetail(programId);
        Map<ActivityGroupType, List<PublicActivityWorkoutListDetailResponse>> programList = collectionData.getPublicProgramListDetail(programId);
        JWTUserDetail userDetail = (JWTUserDetail) authentication.getPrincipal();
        var isCurrentUser = Objects.equals(userDetail.getId(), program.getOwnerId().getId());
        model.addAttribute("isCurrentUser", isCurrentUser);
        model.addAttribute("program", program);
        model.addAttribute("programList", programList);
        return "dashboard/program_detail";
    }

    @GetMapping("/workout/{id}")
    @ResponseBody
    public ResponseEntity<WorkoutResponse> getWorkout(@PathVariable(name = "id") Long id,
                                                      Authentication authentication) {
        WorkoutResponse data = collectionData.getWorkout(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping("/workout/{id}")
    @ResponseBody
    public ResponseEntity<Boolean> deleteWorkout(@PathVariable(name = "id") Long id,
                                                 Authentication authentication) {
        boolean result = collectionData.deleteWorkoutList(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/workout/{id}")
    @ResponseBody
    public ResponseEntity<Boolean> makePrivate(@PathVariable(name = "id") Long id,
                                               Authentication authentication) {
        boolean result = collectionData.setPrivate(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
