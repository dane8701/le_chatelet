package com.le_chatelet.le_chatelet_back.ldap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

@RestController
public class LoginController {
    @Autowired
    private UserInterface userInterface;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/hello")
    public String sayHello()
    {
        return "hello world";
    }

    @GetMapping("/user")
    @ResponseBody
    public Authentication getLoggedUserDetail(Authentication authentication) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        logger.info("ebfjebef"+principal.toString());
        //get username
        String username = authentication.getName();
        logger.info("test : ");
        //logger.info(userInterface.getPersonNamesByUid(username).toString());


        // concat list of authorities to single string seperated by comma
        String authorityString = authentication
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        // check if the user have authority -roleA
        String role = "role_A";
        boolean isCurrentUserInRole = authentication
                .getAuthorities()
                .stream()
                .anyMatch(role::equals);
        //return Authentication object*/
        return authentication;
    }

    /*@GetMapping("/login")
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
    }*/

}
