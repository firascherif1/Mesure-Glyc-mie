package com.example.mesureglycemie.controller;

import com.example.mesureglycemie.model.Patient;

public class Controller {
    private static Patient patient;
    private static Controller instance = null;
    private Controller(){
        super();
    }

    public static final Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    //Flèche "UserAction" Controller --> Model
    public void createPatient(int age, float valeurMesuree, boolean isFasting){
        patient = new Patient(age, valeurMesuree, isFasting);
    }

    //Flèche "Notify" Controller --> View
    public String getReponse(){
        return patient.getResult();
    }
}
