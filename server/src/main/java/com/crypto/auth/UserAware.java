package com.crypto.auth;


import com.db.User;

public interface UserAware {

    String getLoggedInUser();

    void setUser(User usr);
}
