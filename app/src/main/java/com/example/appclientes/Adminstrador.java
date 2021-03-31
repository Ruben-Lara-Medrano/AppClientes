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
        btnCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup(v);
            }
        });
    }


    public void ShowPopup(View v) {

        dialogBuilder= new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.popup_adminstrador_crear_usuario, null);
        EditText crearNombre = contactPopupView.findViewById(R.id.NombreUsuario);
        EditText editartelefono = contactPopupView.findViewById(R.id.ApellidosUsuario);
        EditText editarpuesto = contactPopupView.findViewById(R.id.SeleccionarEmpresa);
        EditText HoraInicio = contactPopupView.findViewById(R.id.Correo);
        EditText horaFinal = contactPopupView.findViewById(R.id.Puesto);

        Button btnEnviar = contactPopupView.findViewById(R.id.btnCrearUsuario);
        TextView txtclose = contactPopupView.findViewById(R.id.txtclose);

        txtclose.setText("X");
        dialogBuilder.setView(contactPopupView);
        dialog= dialogBuilder.create();
        dialog.show();
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(crearNombre.getText().toString().equals("") || editarpuesto.getText().toString().equals("") || editartelefono.getText().toString().equals("")|| HoraInicio.getText().toString().equals("")|| horaFinal.getText().toString().equals("")){
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