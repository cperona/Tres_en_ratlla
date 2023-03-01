package com.example.tresenratlla2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.tresenratlla2.tresEnRatllaAPI.TresEnRatllaAPI;

public class Joc extends AppCompatActivity {

    private TresEnRatllaAPI tresEnRatllaAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joc);

        //Creem una partida nova i repartim fitxes
        this.tresEnRatllaAPI = new TresEnRatllaAPI();
        tresEnRatllaAPI.reparteixFitxes();

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualitzaJoc(button1, 0);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualitzaJoc(button2, 1);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualitzaJoc(button3, 2);
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualitzaJoc(button4 ,3);
            }
        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualitzaJoc(button5, 4);
            }
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualitzaJoc(button6, 5);
            }
        });

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualitzaJoc(button7, 6);
            }
        });

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualitzaJoc(button8, 7);
            }
        });

        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualitzaJoc(button9, 8);
            }
        });
    }

    private void actualitzaJoc(Button button, int idCasella) {
        if (!tresEnRatllaAPI.casellaOcupada(idCasella) && !tresEnRatllaAPI.jugadorHaEsgotatLesJugades()) {
            tresEnRatllaAPI.tiraFitxa(tresEnRatllaAPI.getJugadorDelTorn(), idCasella);

            // Create a new ImageView
            ImageView imageView = new ImageView(this);

            // Set the image resource for the ImageView
            if (tresEnRatllaAPI.getJugadorDelTorn().getFitxa().equals("x")) {
                imageView.setImageResource(R.drawable.cross);
            }
            else if (tresEnRatllaAPI.getJugadorDelTorn().getFitxa().equals("o")){
                imageView.setImageResource(R.drawable.circle);
            }

            // Set the layout parameters for the ImageView
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            imageView.setLayoutParams(params);

            // Set the scale type for the ImageView
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            // Add the ImageView to the Button
            button.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(getResources(),
                    Bitmap.createScaledBitmap(((BitmapDrawable)imageView.getDrawable()).getBitmap(),
                            50, 50, false)), null, null, null);

            tresEnRatllaAPI.canviaTornJugador();

            if (tresEnRatllaAPI.hiHaGuanyador()) {
                Intent intent = new Intent(this, PartidaAcabada.class);
                intent.putExtra("hiHaGuanyador", tresEnRatllaAPI.hiHaGuanyador());
                intent.putExtra("hiHaEmpat", tresEnRatllaAPI.hiHaEmpat());
                intent.putExtra("nomGuanyador", tresEnRatllaAPI.guanyadorPartida().getNom());
                intent.putExtra("fitxaGuanyador", tresEnRatllaAPI.guanyadorPartida().getFitxa());
                startActivity(intent);
            }
            if (tresEnRatllaAPI.hiHaEmpat()) {
                Intent intent = new Intent(this, PartidaAcabada.class);
                intent.putExtra("hiHaGuanyador", tresEnRatllaAPI.hiHaGuanyador());
                intent.putExtra("hiHaEmpat", tresEnRatllaAPI.hiHaEmpat());
                startActivity(intent);
            }
        }
    }
}