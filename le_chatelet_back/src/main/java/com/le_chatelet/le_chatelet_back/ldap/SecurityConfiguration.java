package com.le_chatelet.le_chatelet_back.ldap;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder
                .ldapAuthentication()
                .userDnPatterns("uid={0}, ou=people")
                .groupSearchBase("ou=groups")
                .contextSource()
                .url("ldap://localhost:8389/dc=springframework,dc=org")
                .and()
                .passwordCompare()
                .passwordEncoder(new LdapShaPasswordEncoder())
                .passwordAttribute("userPassword");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeRequests()
                .antMatchers("/authenticate/login**").anonymous()
                .antMatchers("/ressources/**").authenticated()
                .antMatchers("/assets/**").authenticated()
                .antMatchers("/").authenticated()
                .antMatchers("/authenticate/signin.html").authenticated()
                .and()
                .formLogin()
                .loginPage("/signin.html")
                //.loginProcessingUrl("/authenticate/login")
                .defaultSuccessUrl("/authenticate/error.html")
                .failureUrl("/authenticate/error.html")
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf()
                .disable();

    }
}