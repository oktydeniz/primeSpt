package com.facility.primeSport.controller.front;

import com.facility.primeSport.auth.JWTUserDetail;
import com.facility.primeSport.dto.user.PermissionData;
import com.facility.primeSport.dto.user.UserDetailResponse;
import com.facility.primeSport.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/setting")
public class UserSettingPageController {

    private UserService userService;

    public UserSettingPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String profile(Authentication authentication, Model model, HttpServletRequest request){
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "register/login";
        }
        JWTUserDetail userDetail = (JWTUserDetail) authentication.getPrincipal();
        UserDetailResponse user = userService.getUserProfileInformation(userDetail.getId());
        model.addAttribute("user", user);
        return "setting/setting";
    }

    @PostMapping("/permissions")
    @ResponseBody
    public ResponseEntity<Boolean> setPermissions(Authentication authentication, @RequestBody PermissionData data){
        JWTUserDetail userDetail = (JWTUserDetail) authentication.getPrincipal();
        Boolean result = userService.updateUSerPermissions(data, userDetail.getId());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/language")
    public ResponseEntity<Boolean> updateLanguage(Authentication authentication, @RequestParam String language) {
        JWTUserDetail userDetail = (JWTUserDetail) authentication.getPrincipal();
        return userService.updateLanguage(language, userDetail.getId());
    }
}
