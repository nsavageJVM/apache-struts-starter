package com.crypto.cal;

import com.crypto.auth.UserAware;
import com.db.JpaSimpleService;
import com.db.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public abstract class CalTrait extends ActionSupport  implements SessionAware, UserAware {

    protected User usr;
    protected Map<String, Object> sessionMap;

    protected static final Logger logger = LogManager.getLogger("calender crud action");
    protected static final JpaSimpleService jpaSimpleService = JpaSimpleService.getInstance();


    public abstract String setUpGui() throws Exception;


    @Override
    public String getLoggedInUser() {
        return this.usr.getEmail() ;
    }

    @Override
    public void setUser(User usr) {
        this.usr = usr;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.sessionMap = session;
    }


}
