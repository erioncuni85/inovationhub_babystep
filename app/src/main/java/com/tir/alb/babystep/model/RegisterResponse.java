package com.tir.alb.babystep.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AlmotechHome on 3/14/2017.
 */

public class RegisterResponse {

    private Boolean error;
    private String message;
    private String token;
    private RegisterData data;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RegisterData getData() {
        return data;
    }

    public void setData(RegisterData data) {
        this.data = data;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}