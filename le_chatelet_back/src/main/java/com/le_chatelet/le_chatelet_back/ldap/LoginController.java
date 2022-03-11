package com.le_chatelet.le_chatelet_back.ldap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/authenticate/login")
    public String login(){
        return "/authenticate/signin.html";
    }

    @RequestMapping("/home")
    public String logout(){
        return "home_page";
    }

}
