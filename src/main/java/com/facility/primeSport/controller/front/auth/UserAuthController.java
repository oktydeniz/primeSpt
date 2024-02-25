package com.facility.primeSport.controller.front.auth;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAuthController {

    @GetMapping("/login")
    public String login(Authentication authentication, HttpSession session){
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "register/login";
        }
        return "redirect:/home/dashboard";
    }

    @GetMapping("/register")
    public String register(Authentication authentication, HttpSession session){
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "register/register";
        }
        return "redirect:/";
    }

    @GetMapping("/password")
    public String password(Authentication authentication, HttpSession session){
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "register/forgot_password";
        }
        return "redirect:/";
    }

    @GetMapping("/password/reset")
    public String resetPassword(Authentication authentication, HttpSession session){
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "register/change_password";
        }
        return "redirect:/";
    }

}
