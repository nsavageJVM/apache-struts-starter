package com.crypto.auth;


import com.crypto.login.Login;
import com.crypto.login.Register;
import com.db.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;


/**
 *  see  com.LocalDispatch
 */
public class AuthenticationInterceptor  implements Interceptor {

    private static final Logger logger = LogManager.getLogger(AuthenticationInterceptor.class);



    @Override
    public void destroy() {
        logger.debug("authentication interceptor is shutting down ");

    }

    @Override
    public void init() {

        logger.debug("authentication interceptor is initialising  ");
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
 
        logger.debug("authentication intercept");

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.

        Map session = invocation.getInvocationContext().getSession();
        User user = (User) session.get(SecurityProvider.getInstance().getUserKey());

        Object action = invocation.getAction();

//        if (Objects.nonNull(user)) {
//            if ( (action instanceof Login) || (action instanceof Register) ) {
//                return invocation.invoke();
//            }  else {
//                return "login_redirect";
//            }
//        }

        if (action instanceof UserAware   ) {
            ((UserAware) action).setUser(user);
        }


        return invocation.invoke();
    }

}


