package com.le_chatelet.le_chatelet_back.model;

import java.util.Random;

public class User {
    private String lastName;
    private String firstName;
    private String login;
    private String hash;
    private String number;
    private String mail;
    private String token;

    public User(String lastName, String firstName, String login, String hash, String number, String mail) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.login = login;
        this.hash = hash;
        this.number = number;
        this.mail = mail;

        Random random = new Random();
        this.token = Integer.toString(random.nextInt(100000,999999));
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
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

    public String getMessage(){
        return "Votre code de vérification Le Chatelet est : " + this.token;
    }
}
