package com.crypto.login;

import com.db.JpaSimpleService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public abstract  class AuthTrait extends ActionSupport implements SessionAware {

    protected static final JpaSimpleService jpaSimpleService = JpaSimpleService.getInstance();

    protected Map<String,Object> sessionMap;


    @Override
    public void setSession(Map<String, Object> session) {

        this.sessionMap = session;

    }



}
