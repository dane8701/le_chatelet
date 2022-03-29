package com.le_chatelet.le_chatelet_back.ldap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)

@Controller
public class PageController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
