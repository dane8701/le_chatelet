package com.le_chatelet.le_chatelet_back.ldap;

import com.le_chatelet.le_chatelet_back.model.User;
import com.le_chatelet.le_chatelet_back.services.SenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class LoginController {

    private Map<String ,User> map = new HashMap<>();
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getLoggedUserDetail(Authentication authentication, @AuthenticationPrincipal Person person) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = new User(person.getSn(), person.getGivenName(), person.getUsername(), person.getTelephoneNumber(), person.getUsername()+"@chatelet.com");
        this.map.put(user.getUsername(), user);
        return user;
    }

    @GetMapping("/phone-number")
    public void phoneNumber() {
        logger.info(this.map.get("").toString());
    }

}
