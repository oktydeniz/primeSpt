package com.facility.primeSport.controller.front;


import com.facility.primeSport.service.UserManagementService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserManagement {

    private UserManagementService userManagementService;

    @GetMapping
    public String getUsers(HttpServletRequest request, Model model, Authentication authentication){
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }
        return "management/user_management";
    }

}
