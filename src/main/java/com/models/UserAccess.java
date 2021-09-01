package com.models;


import com.tools.constants.EnvironmentConstants;

public class UserAccess {
    private String key, token;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserAccess(){
        this.setKey(EnvironmentConstants.API_KEY);
        this.setToken(EnvironmentConstants.API_TOKEN);
    }
}
