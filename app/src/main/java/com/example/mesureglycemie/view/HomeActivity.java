package com.example.mesureglycemie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mesureglycemie.R;
import com.example.mesureglycemie.controller.HomeController;

public class HomeActivity extends AppCompatActivity {

    private HomeController homeController;

    private Button btnConsultation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init() {
        btnConsultation = findViewById(R.id.btnConsultation);
        homeController = HomeController.getInstance(this);
    }
}