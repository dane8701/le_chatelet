package com.le_chatelet.le_chatelet_back.ldap;

import com.le_chatelet.le_chatelet_back.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.Person;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
public class LoginController {

    private final Map<String ,User> map = new HashMap<String,User>();
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getLoggedUserDetail(@AuthenticationPrincipal Person person) {

        String number = person.getTelephoneNumber().replaceFirst("0", "+33");
        User user = new User(person.getSn(), person.getGivenName(), person.getUsername(), number, person.getUsername()+"@chatelet.com");
        user.generateToken();
        logger.info(user.getToken());
        this.map.put(user.getLogin(), user);
        return user;
    }

    @PostMapping(value = "/user/2fa", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity compareToken(@RequestBody User person){
        String token = this.map.get(person.getLogin()).getToken();
        if (person.getToken().equals(token)){
            return ResponseEntity.ok().build();
        }
        else {
            this.map.get(person.getLogin()).generateToken();
            logger.info("changing token to : "+ this.map.get(person.getLogin()).getToken());
            SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
            SecurityContextHolder.clearContext();
            return ResponseEntity.status(403).build();
        }
    }
}