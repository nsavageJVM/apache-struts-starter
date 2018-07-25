package com.db;

import com.db.jpa.JpaTransactionManager;

import java.util.List;
import java.util.Objects;

public class JpaSimpleService {

    private static final JpaTransactionManager jpaManager = JpaTransactionManager.getInstance();



    private static class JpaSimpleServiceProvider {
        static final JpaSimpleService INSTANCE = new JpaSimpleService(); }

    public static JpaSimpleService getInstance() {
        return JpaSimpleServiceProvider.INSTANCE;
    }

    private static User sessionUser;
    public static User getSessionUser() {
        return sessionUser;
    }

    public Boolean runLoginTest( String email, String psswd) {

        List<User> users = jpaManager.findByField(  User.class, "email", email).getResultList();
        User usrsF = users.stream().filter( u -> (!u.getEmail().contains(psswd) ) ) .findFirst().get();

       if(Objects.nonNull(usrsF)){
           sessionUser = usrsF;
           return true;
       }
       else return false;

    }

    public User createUser(String email, String password) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        return jpaManager.save(user);
    }


}
