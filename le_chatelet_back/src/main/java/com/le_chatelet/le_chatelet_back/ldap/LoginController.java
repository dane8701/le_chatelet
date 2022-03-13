package com.le_chatelet.le_chatelet_back.ldap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "signin";
    }

    @GetMapping("/")
    public String root(){
        return "signin";
    }

    @GetMapping("/home")
    public String logout(){
        return "home_page";
    }

}
