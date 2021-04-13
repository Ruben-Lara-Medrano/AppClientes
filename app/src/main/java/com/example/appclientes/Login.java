package com.example.appclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Login extends AppCompatActivity {
    private EditText correo, pass;
    private Button LogIn;
    private TextView OlvidoContra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        correo = findViewById(R.id.EmailLogin);
        pass = findViewById(R.id.PasswordLogin);
        LogIn = findViewById(R.id.EntrarLogin);
        OlvidoContra = findViewById(R.id.OlvidoContrasena);
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion(v);
            }
        });
        OlvidoContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OlvidoContra(v);
            }
        });
    }

/* Metodo para iniciar sesion.*/
    //todo El JDBC a postgre y su conexion.
    public void iniciarSesion(View view) {
        if (correo.getText().toString().equals("") || pass.getText().toString().equals("")) {
            Snackbar snackbar = Snackbar.make(view, R.string.dastosVaciosLogin, Snackbar.LENGTH_LONG);
            snackbar.setDuration(2000);
            snackbar.show();
        }
        else if(pass.length()>9){
            Snackbar snackbar = Snackbar.make(view, R.string.pass9caracteres,Snackbar.LENGTH_LONG);
            snackbar.setDuration(2000);
            snackbar.show();
        }else {
            if(correo.getText().toString().equals("1234") && pass.getText().toString().equals("1234")){
                Intent i = new Intent(getApplicationContext(), Adminstrador.class);
                startActivity(i);
                Snackbar snackbar = Snackbar.make(view, R.string.inicioSesionCorrecto, Snackbar.LENGTH_LONG);
                snackbar.setDuration(2000);
                snackbar.show();
            }
            else {
                Intent i = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(i);
                Snackbar snackbar = Snackbar.make(view, R.string.inicioSesionCorrecto, Snackbar.LENGTH_LONG);
                snackbar.setDuration(2000);
                snackbar.show();
            }
        }
    }

    public void OlvidoContra(View view){
        Intent i = new Intent(getApplicationContext(), OlvidoContrasena.class);
        startActivity(i);
    }
}