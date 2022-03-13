package com.le_chatelet.le_chatelet_back.ldap;

import com.le_chatelet.le_chatelet_back.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LdapController {
    @Autowired
    private UserInterface userInterface;

    @GetMapping("/get-user")
    public String findLdapPerson() {
        return userInterface.getPersonNamesByUid("ben").getLastName();
    }
}
