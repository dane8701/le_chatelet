package com.le_chatelet.le_chatelet_back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Random;

public class User implements UserDetails {
    private String lastName;
    private String firstName;
    private String login;
    private String number;
    private String mail;
    private String token;

    public User(String lastName, String firstName, String login, String number, String mail) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.login = login;
        this.number = number;
        this.mail = mail;

        Random random = new Random();
        this.token = Integer.toString(random.nextInt(100000,999999));
    }

    public User(String login, String password){
        this.login = login;
    }

    public User(String login, String number, String mail){
        this.login = login;
        this.number = number;
        this.mail = mail;

    }
    public User() {
    }

    @Override
    public String toString() {
        return "{" +
                "lastName: " +this.lastName+
                "firstName: " +this.firstName+
                "login: " +this.login+
                "number: " +this.number+
                "mail: " +this.mail+
                "}";
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void generateToken(){
        Random random = new Random();
        this.token = Integer.toString(random.nextInt(100000,999999));
    }

    @JsonIgnore
    public String getMessage(){
        return "Votre code de vérification Le Chatelet est : " + this.token;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return null;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return false;
    }
}
