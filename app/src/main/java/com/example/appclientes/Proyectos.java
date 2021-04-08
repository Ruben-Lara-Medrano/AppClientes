package com.example.appclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Proyectos extends AppCompatActivity {
        //todo hacer el recyclerview de proyectos
    private FloatingActionButton MeterProyectos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectos);
       /** MeterProyectos = findViewById(R.id.MeterProyectos);

        MeterProyectos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopUp(v);
            }
        });*/
    }
    public void ShowPopUp(View v){

    }
}