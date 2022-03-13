package com.le_chatelet.le_chatelet_back.ldap;

import org.springframework.ldap.NamingException;
import org.springframework.ldap.core.AttributesMapper;

import javax.naming.directory.Attributes;

public class UserNameAttributesMapper implements AttributesMapper<String> {
    public String mapFromAttributes(Attributes attrs) throws NamingException {
        try {
            return attrs.get("cn").get().toString();
        } catch (javax.naming.NamingException e) {
            e.printStackTrace();
        }
        return null;
    }
}