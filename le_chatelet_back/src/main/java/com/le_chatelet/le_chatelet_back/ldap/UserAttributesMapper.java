package com.le_chatelet.le_chatelet_back.ldap;

import com.le_chatelet.le_chatelet_back.model.User;
import org.springframework.ldap.NamingException;
import org.springframework.ldap.core.AttributesMapper;

import javax.naming.directory.Attributes;

public class UserAttributesMapper implements AttributesMapper<User> {

    @Override
    public User mapFromAttributes(Attributes attrs){
        User user = new User();
        try {
            user.setFirstName((String) attrs.get("cn").get());
        } catch (javax.naming.NamingException e) {
            e.printStackTrace();
        }
        try {
            user.setLastName((String) attrs.get("sn").get());
        } catch (javax.naming.NamingException e) {
            e.printStackTrace();
        }
        return user;
    }

}