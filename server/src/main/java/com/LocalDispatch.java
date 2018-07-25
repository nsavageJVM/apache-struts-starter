package com;

import com.crypto.auth.SecurityProvider;
import com.db.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


/**
 *
 * idea is cant do this as an action  with json plugin hijacks actions
 *
 * layout.jsp  calls this to check logged in use exists to control back button
 *
 * this is the root namespace
 *
 */
public class LocalDispatch  extends ActionSupport {

    private static final Logger logger = LogManager.getLogger(LocalDispatch.class);


    public String checkSession() {

        HttpServletRequest request = ServletActionContext.getRequest();

        User user = (User) request.getSession().getAttribute(SecurityProvider.getInstance().getUserKey());

        ActionMapping actionMap = (ActionMapping) request.getAttribute("struts.actionMapping");

        if(actionMap.getName().equals("authAction") && Objects.isNull(user)) {
            logger.debug("LocalDispatch null user continue to  loginRedirect");
            return "loginRedirect" ;
        }

        else    {
            logger.debug("LocalDispatch non null user continue to  page");
            return SUCCESS;
        }

    }
}
