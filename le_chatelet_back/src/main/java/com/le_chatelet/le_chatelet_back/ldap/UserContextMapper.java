/*package com.le_chatelet.le_chatelet_back.ldap;

import com.le_chatelet.le_chatelet_back.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.Collection;

@Service
public class UserContextMapper implements UserDetailsContextMapper {
    private final Logger logger= LoggerFactory.getLogger(UserContextMapper.class);
    private User user = null;
    private String lastName= null;
    private String firstName= null;
    private String login= null;
    private String number= null;
    private String mail= null;

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
        Attributes attributes = ctx.getAttributes();
        logger.info("knkenvkke");
        logger.info("Attribute : {}", attributes);
        this.login=username;
        try {
            this.firstName=(String) attributes.get("GivenName").get();
            logger.info(this.firstName);
            //this.lastName=(String) attributes.get("Surname").get(); //use sn
            this.mail=(String) attributes.get("UserPrincipalName").get();
            this.number=(String) attributes.get("telephoneNumber").get();
            logger.info(this.number);

        } catch (NamingException e) {
            e.printStackTrace();
        }

        User user = new User(this.lastName, this.firstName, this.login, this.number, this.mail);
        this.user = user;
        return user;
    }

    public User getUser() {
        return this.user;
    }

    @Override
    public void mapUserToContext(UserDetails user, DirContextAdapter ctx) {

    }
}*/
