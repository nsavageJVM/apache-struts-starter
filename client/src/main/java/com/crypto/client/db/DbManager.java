package com.crypto.client.db;


import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Objects;

import static java.lang.Class.forName;

@Component
public class DbManager {


    private Connection connection = null;

    private static String user_home = System.getProperty("user.home");



    private String session_db = "sqlite.db", default_usr_email = "john@doe.com", default_usr_psswd = "tmp123";


    static {
        try {
            forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String init() {

        StringBuilder schema = null;

        try {

            Statement statement = setConnection().createStatement();
            statement.setQueryTimeout(3);

            QueryRunner run = new QueryRunner();
            run.update(setConnection(), "insert into User values (?,?,?)", new Object[]{1, default_usr_email, default_usr_psswd});

            DatabaseMetaData databaseMetaData = setConnection().getMetaData();
            ResultSet resultSet =   databaseMetaData.getSchemas();
            schema = new StringBuilder("Schema created:= ");
            while (resultSet.next()) {
                schema.append( resultSet.getString(1) );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schema.toString();
    }


    private Connection setConnection() {

        if (Objects.isNull(connection)) {
            try {
                connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s/%s", user_home, session_db));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }


}
