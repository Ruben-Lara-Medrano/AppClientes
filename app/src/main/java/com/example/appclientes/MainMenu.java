package com.example.appclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    private Button PartesHoras,Fichajes,Proyectos,Compras,Ventas, Perfil,Salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        PartesHoras = findViewById(R.id.PartesHoras);
        Fichajes = findViewById(R.id.Fichajes);
        Proyectos = findViewById(R.id.Proyectos);
        //Compras = findViewById(R.id.);
        Perfil = findViewById(R.id.Perrfil);
        Salir = findViewById(R.id.Salir);

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
    }
}