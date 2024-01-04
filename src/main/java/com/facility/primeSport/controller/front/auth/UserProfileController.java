package com.facility.primeSport.controller.front.auth;

import com.facility.primeSport.service.CollectionData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class UserProfileController {

    private CollectionData collectionData;


    public UserProfileController(CollectionData collectionData) {
        this.collectionData = collectionData;
    }

    @GetMapping
    public String profile(Authentication authentication, HttpServletRequest request, Model model){
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "redirect:/login";
        }
        model.addAttribute("activities", collectionData.getActivityTypes());
        return "profile/profile";
    }

    @GetMapping("/program/{programId}")
    public String program(Authentication authentication, HttpServletRequest request, Model model,
                          @PathVariable(name = "programId") Long programId){
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "redirect:/login";
        }
        model.addAttribute("activities", collectionData.getActivityTypes());
        return "profile/profile";
    }
}
