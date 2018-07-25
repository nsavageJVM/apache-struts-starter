package com.crypto.login;

import com.db.jpa.EMFProducer;
import com.db.User;
import com.opensymphony.xwork2.ActionSupport;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.EntityManager;
import java.util.Map;


public class Register extends ActionSupport {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static EntityManager em = EMFProducer.getInstance().getEntityManager();
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String email;
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String password;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Map<String, Object> sessionMap;


    public String setUpGui() throws Exception {

        return "input";
    }


    public String execute() {

        User user = new User();
        user.setPassword(getPassword());

        user.setEmail(getEmail());
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        return SUCCESS;
    }


}