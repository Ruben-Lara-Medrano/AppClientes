package com.example.appclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Perfil extends AppCompatActivity {
    private Button cambiarDatos,cambiarLocalizacionMaps, volver;
    private TextView cambiarFoto;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICACION_ID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        volver= findViewById(R.id.volver);
        cambiarDatos = findViewById(R.id.editarCaracteristicas);
        cambiarFoto = findViewById(R.id.CambiarFoto);
        //Poner que sea invisible segun el tipo de usuario que se meta
       /** if(userId==//usuario de postgre){
            ImageButton llamar = findViewById(R.id.btnLlamar);
            textoCambiarImagen.setVisibility(View.INVISIBLE);
            spinner.setVisibility(View.INVISIBLE);
            logout.setVisibility(View.INVISIBLE);
            editar.setVisibility(View.INVISIBLE);
            quitarMusica.setVisibility(View.INVISIBLE);
        }else{

        }*/


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(i);            }
        });

        cambiarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopUp(v);
            }
        });
        cambiarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarImagen();
            }
        });
    }
    public void cambiarImagen(){
        Intent i = new Intent();
        startActivity(i);
    }
    public void ShowPopUp(View v){
        dialogBuilder= new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.popup_modificar_usuario, null);
        EditText editarNombre = contactPopupView.findViewById(R.id.Proyecto);
        EditText editarpuesto = contactPopupView.findViewById(R.id.Estado);
        EditText editartelefono = contactPopupView.findViewById(R.id.PlantillaPresupuesto);
        EditText editarCorreo = contactPopupView.findViewById(R.id.Validez);

        Button btnEnviar = contactPopupView.findViewById(R.id.btnSubirProyecto);
        TextView txtclose = contactPopupView.findViewById(R.id.txtclose);

        txtclose.setText("X");
        dialogBuilder.setView(contactPopupView);
        dialog= dialogBuilder.create();
        dialog.show();
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editarNombre.getText().toString().equals("") || editarpuesto.getText().toString().equals("") || editartelefono.getText().toString().equals("")|| editarCorreo.getText().toString().equals("")){
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
    }
}