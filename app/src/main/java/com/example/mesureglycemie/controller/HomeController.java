package com.example.mesureglycemie.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mesureglycemie.model.Patient;
import com.example.mesureglycemie.model.User;

public class HomeController {
    private static User user;
    private static HomeController instance = null;
    private static final String SHARED_PREFS = "HomeActivitySharedPrefs";

    private HomeController(){
        super();
    }

    public static final HomeController getInstance(Context context){
        if(instance == null){
            instance = new HomeController();
        }
        recapUser(context);
        return instance;
    }

    //Flèche "UserAction" Controller --> Model
    public void createUser(String email, String password, Context context){
        user = new User(email, password);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();

    }

    //Flèche "Notify" Controller --> View
    public static void recapUser(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email","");
        String password = sharedPreferences.getString("password", "");
        user = new User(email, password);
    }

    public static String getUserEmail() {
        return user.getEmail();
    }
    public static String getUserPassword() {
        return user.getPassword();
    }

}
