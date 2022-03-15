package com.le_chatelet.le_chatelet_back.ldap;

import com.le_chatelet.le_chatelet_back.model.User;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Service
public class LdapUser extends LdapUserDetailsImpl implements UserInterface{
    private final LdapTemplate ldapTemplate;

    public LdapUser(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    @Override
    public User getPersonNamesByUid(String userId) {
        //ldapTemplate.authenticate();
        List<User> people = ldapTemplate.search(query().where("uid").is(userId), new UserAttributesMapper());
        return ((null != people && !people.isEmpty()) ? people.get(0) : null);
    }
}
