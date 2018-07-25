package com.crypto.auth;



public class SecurityProvider {


    private static final String USER_KEY = "xacsvd";


    private static class SecurityProviderHolder { static final SecurityProvider INSTANCE = new SecurityProvider(); }

    public static SecurityProvider getInstance() {
        return SecurityProviderHolder.INSTANCE;
    }

    public static String getUserKey() { return USER_KEY; }



}
