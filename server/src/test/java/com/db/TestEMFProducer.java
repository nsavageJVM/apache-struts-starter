package com.db;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestEMFProducer {

    private static final Logger logger = LogManager.getLogger (TestEMFProducer.class);


    private static String user_home = System.getProperty("user.home");
    private String session_db = "sqlite_test.db";
    private static String user_db_template = "jdbc:sqlite:%s/%s";

    private  EntityManager sessionEMF;


    private static EntityManagerFactory entityManagerFactory = null;

    private TestEMFProducer() {

        if(Objects.isNull(entityManagerFactory)) {

            // set url dynamically hibernate.connection.url
            String dbConnectionUrl = String.format(user_db_template, user_home, session_db);
            logger.debug("EMFProducer is initialising db with conncetion url "+dbConnectionUrl );
            Map<String, Object> props = new HashMap<>();
            props.put("javax.persistence.jdbc.url", dbConnectionUrl );
            entityManagerFactory = Persistence.createEntityManagerFactory("local_sql_lite_test", props);
            sessionEMF = entityManagerFactory.createEntityManager();

        }

    }

    private static class EMFProvider {
        static final TestEMFProducer INSTANCE = new TestEMFProducer();
    }

    public static TestEMFProducer getInstance() {
        return EMFProvider.INSTANCE;
    }


    public EntityManager getEntityManager()  {
        if(entityManagerFactory != null)  {
            sessionEMF = entityManagerFactory.createEntityManager();
        }
        return sessionEMF;
    }


    public void  closeEntityManager()  {

        if(sessionEMF != null)  {

            sessionEMF.close();
        }

    }



}
