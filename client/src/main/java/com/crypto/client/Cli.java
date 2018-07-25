package com.crypto.client;


import com.crypto.client.db.DbManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class Cli {




    @Autowired
    private DbManager dbManager;



    @ShellMethod(" initialise db for server")
    public String iniDb()  {


      String schemaData =   dbManager.init();

        return schemaData;
    }


}
