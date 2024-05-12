package com.example.mesureglycemie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mesureglycemie.R;

public class ConsultActivity extends AppCompatActivity {
    private final String RESPONSE_KEY = "reponse";
    private TextView tvReposne;
    private Button btnRetour;
    private String reponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        init();
        // Récupération de l'intent
        Intent intent = getIntent();
        // Récupération du String transmis dans l'intent
        reponse = intent.getStringExtra(RESPONSE_KEY);
        // Mise à jour du TextView avec le résultat de l'analyse
        tvReposne.setText(reponse);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Création d'une nouvelle Intent pour retourner à MainActivity
                Intent retourIntent = new Intent();
                if(reponse == null)
                    setResult(RESULT_CANCELED, retourIntent);
                else
                    setResult(RESULT_OK, retourIntent);
                // Fermeture de l'activité ConsultActivity
                finish();
            }
        });
    }

    private void init() {
        tvReposne = findViewById(R.id.tvReponse);
        btnRetour = findViewById(R.id.btnRetour);
    }
}