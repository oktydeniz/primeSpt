package com.facility.primeSport.controller.front;

import com.facility.primeSport.dto.chart.GraphRequest;
import com.facility.primeSport.dto.chart.GraphResponse;
import com.facility.primeSport.service.UserActivitiesService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/activities")
public class ActivitiesController {


    private final UserActivitiesService userActivitiesService;


    public ActivitiesController(UserActivitiesService userActivitiesService) {
        this.userActivitiesService = userActivitiesService;
    }

    @GetMapping
    public String activities(Authentication authentication) {
        return "activities/activities_index";
    }


    @GetMapping("/chart")
    @ResponseBody
    public List<GraphResponse> getUserDataByType(Authentication authentication, @RequestBody GraphRequest request){
        return userActivitiesService.userActivities(request);
    }
}