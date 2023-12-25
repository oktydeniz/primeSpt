package com.facility.primeSport.controller.front;

import com.facility.primeSport.auth.JWTUserDetail;
import com.facility.primeSport.service.UDailyAnalyticsService;
import lombok.Getter;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private UDailyAnalyticsService dailyAnalyticsService;

    public HomeController(UDailyAnalyticsService dailyAnalyticsService) {
        this.dailyAnalyticsService = dailyAnalyticsService;
    }

    @GetMapping
    public String home(Model model){
        return "index/m_index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model){
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "/login";
        }
        JWTUserDetail userDetail = (JWTUserDetail) authentication.getPrincipal();
        model.addAttribute("dailyReports", dailyAnalyticsService.getDailyData(userDetail.getId()));
        return "dashboard/dashboard";
    }


    @GetMapping("/private")
    public String privateEnd(Model model){
        return "register/login";
    }
}
