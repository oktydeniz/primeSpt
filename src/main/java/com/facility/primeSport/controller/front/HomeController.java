package com.facility.primeSport.controller.front;

import com.facility.primeSport.auth.JWTUserDetail;
import com.facility.primeSport.dto.fitness.ActivityTypeResponse;
import com.facility.primeSport.dto.fitness.PublicActivityWorkoutResponse;
import com.facility.primeSport.dto.user.UserDailyDataResponse;
import com.facility.primeSport.entitiy.activity.PublicActivityWorkoutList;
import com.facility.primeSport.entitiy.fitness.ActivityType;
import com.facility.primeSport.service.CollectionData;
import com.facility.primeSport.service.UDailyAnalyticsService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

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
    public String home(Model model){
        return "index/m_index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model){
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
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
                             Authentication authentication){
        List<PublicActivityWorkoutResponse> category = collectionData.getByCategory(categoryId);
        ActivityType activity = collectionData.getActivityType(categoryId);
        model.addAttribute("category", category);
        model.addAttribute("activity", activity);
        return "dashboard/category";
    }
}
