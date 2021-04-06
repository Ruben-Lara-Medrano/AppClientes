package com.example.appclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Adminstrador extends AppCompatActivity {
    private Button btnCrearUsuario, btnEliminarUsuario, btnModificarUsuario;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminstrador);
        btnCrearUsuario= findViewById(R.id.btnInsertarUsuario);
        btnEliminarUsuario= findViewById(R.id.btnBorrarUsuario);
        btnCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup(v);
            }
        });
        btnEliminarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopupEliminarUsuario(v);
            }
        });
    }


    public void ShowPopup(View v) {

        dialogBuilder= new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.pop_up_insertarusuario_administrador, null);
        EditText crearNombre = contactPopupView.findViewById(R.id.NombrePerfil);
        EditText contrasena = contactPopupView.findViewById(R.id.contrasena);
        Button btnEnviar = contactPopupView.findViewById(R.id.btnCambiarUsuario);
        TextView txtclose = contactPopupView.findViewById(R.id.txtclose);

        txtclose.setText("X");
        dialogBuilder.setView(contactPopupView);
        dialog= dialogBuilder.create();
        dialog.show();
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(crearNombre.getText().toString().equals("") || contrasena.getText().toString().equals("")){
                    Snackbar snackbar = Snackbar.make(v, R.string.dastosVacios , Snackbar.LENGTH_LONG);
                    snackbar.setDuration(2000);
                    snackbar.show();
                }
                else{
                    //todo Hacer la insercion de datos en postgre aqui de los partes de horas.
                    dialog.cancel();
                }
            }
        });

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        //contactPopupView.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
    public void ShowPopupEliminarUsuario(View v) {

        dialogBuilder= new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.pop_up_borrarusuario_administrador, null);
        EditText EliminarUsuarioNombre = contactPopupView.findViewById(R.id.NombrePerfil);
        EditText EliminarContrasenaUsuairo = contactPopupView.findViewById(R.id.contrasena);
        Button btnEnviar = contactPopupView.findViewById(R.id.btnCambiarUsuario);
        TextView txtclose = contactPopupView.findViewById(R.id.txtclose);

        txtclose.setText("X");
        dialogBuilder.setView(contactPopupView);
        dialog= dialogBuilder.create();
        dialog.show();
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(EliminarUsuarioNombre.getText().toString().equals("") || EliminarContrasenaUsuairo.getText().toString().equals("")){
                    Snackbar snackbar = Snackbar.make(v, R.string.dastosVacios , Snackbar.LENGTH_LONG);
                    snackbar.setDuration(2000);
                    snackbar.show();
                }
                else{
                    //todo Hacer la insercion de datos en postgre aqui de los partes de horas.
                    dialog.cancel();
                }
            }
        });

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        //contactPopupView.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
}