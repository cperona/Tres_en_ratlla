package com.example.tresenratlla2;

import android.content.Intent;
import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Inici extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inici);

        //Amaguem la title bar
        getSupportActionBar().hide();

        Button jugarButton = findViewById(R.id.jugarButton);
        jugarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Joc.class);
                startActivity(intent);
            }
        });

        Button jugarAmbLaMaquinaButton = findViewById(R.id.jugarAmbLaMaquinaButton);
        jugarAmbLaMaquinaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Joc.class);
                startActivity(intent);
            }
        });

        ImageView configuracioButton = findViewById(R.id.configuracioButton);
        configuracioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Configuracio.class);
                startActivity(intent);
            }
        });

        ImageView perfilButton = findViewById(R.id.perfilButton);
        perfilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Perfil.class);
                startActivity(intent);
            }
        });

        ImageView rankingButton = findViewById(R.id.rankingButton);
        rankingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Ranking.class);
                startActivity(intent);
            }
        });

        ImageView amicsButton = findViewById(R.id.amicsButton);
        amicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Amics.class);
                startActivity(intent);
            }
        });
    }
}