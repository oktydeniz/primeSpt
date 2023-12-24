package com.facility.primeSport.controller.front;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home(Model model){
        return "index/m_index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        return "dashboard/dashboard";
    }


    @GetMapping("/private")
    public String privateEnd(Model model){
        return "register/login";
    }
}
