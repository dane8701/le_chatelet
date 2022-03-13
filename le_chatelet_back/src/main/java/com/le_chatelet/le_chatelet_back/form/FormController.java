package com.le_chatelet.le_chatelet_back.form;

import com.le_chatelet.le_chatelet_back.ldap.LdapUser;
import com.le_chatelet.le_chatelet_back.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FormController {
    private LdapUser ldapUser;

    private static String getUserFromLdapResearch(List<String> ldapUsersList, String login){
        for (String user : ldapUsersList){
            if (user.equals(login)){
                return user;
            }
        }

        return null;
    }

    @PostMapping(value = "/authenticate",
            consumes = "application/json",
            produces = "application/json")
    public void checkLogin(@RequestBody User user){
        List<String> ldapResearch = ldapUser.searchUser(user.getLogin());
        if (!ldapResearch.contains(null)){
            user.setFirstName(FormController.getUserFromLdapResearch(ldapResearch, user.getLogin()));
        }
    }

}
