package com.le_chatelet.le_chatelet_back.ldap;

import com.le_chatelet.le_chatelet_back.model.User;

import java.util.List;

public interface UserInterface {

    public User getPersonNamesByUid(String userId);

}
