package com.facility.primeSport.controller.front;


import com.facility.primeSport.auth.JWTUserDetail;
import com.facility.primeSport.dto.fitness.CreateActivityRequest;
import com.facility.primeSport.service.ActivityService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Boolean> createActivity(Authentication authentication,
                                                  @RequestBody CreateActivityRequest createActivity) {
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
        JWTUserDetail user = (JWTUserDetail) authentication.getPrincipal();
        return activityService.createNewActivity(createActivity, user.getId());
    }
}
