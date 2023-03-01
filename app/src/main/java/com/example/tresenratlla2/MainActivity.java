package com.example.tresenratlla2;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Amaguem la title bar
        getSupportActionBar().hide();

        //Canviem a l'activitat Inici
        Intent intent = new Intent(this, Inici.class);
        startActivity(intent);
    }
}