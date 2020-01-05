package com.ducen.predictor.session;

public interface SessionManager {

    void createSession(String name, String value);

    void createSession(String name, Boolean value);

    void createLoginSession(String name);

    void logoutUser();

    void deleteSession(String name);

    String getStringSession(String name);

    Boolean getBooleanSession(String name);

    void reset();

}
