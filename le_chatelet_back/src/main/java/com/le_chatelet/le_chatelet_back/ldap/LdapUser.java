package com.le_chatelet.le_chatelet_back.ldap;

import com.le_chatelet.le_chatelet_back.model.User;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;

import java.util.List;

public class LdapUser implements UserInterface{
    private LdapTemplate ldapTemplate;

    public void setLdapTemplate(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    @Override
    public List<String> searchUser(String login) {
        return ldapTemplate
                .search(
                        "ou=users",
                        "cn=" + login,
                        (AttributesMapper<String>) attrs -> String.valueOf((User) attrs.get("cn").get()));

    }
}
