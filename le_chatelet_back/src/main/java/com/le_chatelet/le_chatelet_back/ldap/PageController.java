package com.le_chatelet.le_chatelet_back.ldap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
