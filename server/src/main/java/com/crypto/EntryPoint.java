package com.crypto;


import com.crypto.auth.SecurityProvider;
import com.crypto.auth.UserAware;
import com.db.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;
import java.util.Objects;

public class EntryPoint extends ActionSupport implements SessionAware, UserAware {

    private static final Logger logger = LogManager.getLogger(EntryPoint.class);

    private User usr;


    private Map<String, Object> sessionMap;


    public String setUpGui() throws Exception {


        return "input";
    }


    @Override
    public String execute() throws Exception {


        return SUCCESS;
    }

    public String logout() throws Exception {

        sessionMap.clear();

        return SUCCESS;
    }


    @Override
    public void setSession(Map<String, Object> session) {

        this.sessionMap = session;

    }

    @Override
    public String getLoggedInUser() {

        if(Objects.isNull(usr)) return null;

        return this.usr.getEmail();
    }


    @Override
    public void setUser(User usrFromSession) {
        this.usr = usrFromSession;
    }
}