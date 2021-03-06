package com.le_chatelet.le_chatelet_back.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class SmsRequest {
    private final User user;

    public SmsRequest(@JsonProperty("user") User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString(){
        return "SmsRequest{" +
                "phoneNumber='" + this.user.getNumber() + '\'' +
                ",message='" + this.user.getMessage() + '\'' +
                "}";
    }
}
