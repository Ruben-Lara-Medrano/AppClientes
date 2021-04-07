package com.example.appclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainMenu extends AppCompatActivity {
    private ImageButton PartesHoras,Fichajes,Proyectos,Compras,Ventas, Perfil,Salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        PartesHoras = findViewById(R.id.btnPartesHoras);
        Fichajes = findViewById(R.id.btnFichajes);
        Proyectos = findViewById(R.id.btnProyectos);
        Ventas = findViewById(R.id.btnVentas);
        //Compras = findViewById(R.id.);
        Perfil = findViewById(R.id.Perfil);
        Salir = findViewById(R.id.btnSalir);

        Proyectos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PartesHoras.class);
                startActivity(i);
            }
        });
        Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Perfil.class);
                startActivity(i);
            }
        });
        Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
        }
    });
        Fichajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Fichajes.class);
                startActivity(i);
            }
        });
        PartesHoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PartesHoras.class);
                startActivity(i);
            }
        });
    }
}