package com.ducen.predictor.session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.ducen.predictor.defaultdata.Session;
import com.ducen.predictor.view.login.LoginActivity;

public class SessionManagerImpl implements SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "DucenSepsisPref";

    //constructor
    public SessionManagerImpl(Context context){
        Log.d("Session Manager :","Constructor Triggered");
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    //create session
    public void createSession(String name,String value){
        Log.d("Create Session :",name);
        editor.putString(name,value);
        editor.commit();
    }
    public void createSession(String name,Boolean value){
        Log.d("Create Session :",name);
        editor.putBoolean(name,value);
        editor.commit();

    }

    //get value
    public String getStringSession(String name){
        Log.d("Get Session :",name);
         return pref.getString(name,null);
    }

    public Boolean getBooleanSession(String name){
        Log.d("Get Session :",name);
        return pref.getBoolean(name,false);
    }

    //delete session
    public void deleteSession(String name){
        Log.d("Delete Session :",name);
        editor.remove(name); // will delete
        editor.commit();
    }
    //create login session
    public void createLoginSession(String name) {
        Log.d("Create Login Session :",name);
        editor.putBoolean(Session.IS_LOGIN.toString(), true);
        editor.putString(Session.USERNAME.toString(), name);
        editor.commit();
    }

    //logout
    public void logoutUser(){
        Log.d("Logout Session :","Successfully Logout");
        editor.remove(Session.IS_LOGIN.toString());
        editor.remove(Session.USERNAME.toString());
        editor.commit();
        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    //reset cache
    public void reset(){
        editor.clear();
        editor.commit();
    }
}
