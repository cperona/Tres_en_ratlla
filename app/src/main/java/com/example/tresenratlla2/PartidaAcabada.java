package com.example.tresenratlla2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PartidaAcabada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida_acabada);

        if (getIntent().getBooleanExtra("hiHaGuanyador", false)) {
            String nomGuanyador = getIntent().getStringExtra("nomGuanyador");
            String fitxaGuanyador = getIntent().getStringExtra("fitxaGuanyador");

            TextView resultatPartidaTextView1 = findViewById(R.id.resultatPartidaTextView1);
            resultatPartidaTextView1.setText("Ha guanyat:");
            TextView resultatPartidaTextView2 = findViewById(R.id.resultatPartidaTextView2);
            resultatPartidaTextView2.setText(String.format("%s amb %s", nomGuanyador, fitxaGuanyador.toUpperCase()));
        }
        if (getIntent().getBooleanExtra("hiHaEmpat", false)) {
            TextView resultatPartidaTextView1 = findViewById(R.id.resultatPartidaTextView1);
            resultatPartidaTextView1.setText("Empat");
            TextView resultatPartidaTextView2 = findViewById(R.id.resultatPartidaTextView2);
            resultatPartidaTextView2.setText("");
        }



        Button tornaAIniciButton = findViewById(R.id.tornaAIniciButton);
        tornaAIniciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Inici.class);
                startActivity(intent);
            }
        });
    }
}