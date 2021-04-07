package com.example.appclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Fichajes extends AppCompatActivity {
    private Button btnComprobar,btnMostrar,btnMostrarFichajes;
    private ImageView btnFichar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichajes);
        btnFichar= findViewById(R.id.btnFichar);
        btnComprobar = findViewById(R.id.botonComprobante);
        btnMostrar = findViewById(R.id.BotonMostarfFichas);
        btnMostrarFichajes = findViewById(R.id.mostarFichajes);

        btnFichar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo hacer que el boton de fichar suba un fichaje al postgre
            }
        });
        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo hacer que el boton de fichar suba un fichaje al postgre este boton tiene la misma funcionalidad que el anterio boton
            }
        });
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo boton para mostrar todas los fichajes del usuario... (Ideas: utilizar un popup para mostrar todos los fichajes.)
            }
        });
        btnMostrarFichajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PartesHoras.class);
                startActivity(i);            }
        });
    }

}