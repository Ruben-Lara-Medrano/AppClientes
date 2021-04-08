package com.example.appclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Ventas extends AppCompatActivity {
    private FloatingActionButton introducirVenta;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);

        introducirVenta = findViewById(R.id.btnMeterVenta);

        introducirVenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopUp(v);
            }
        });
    }
    public void ShowPopUp(View v){
        dialogBuilder= new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.pop_up_ventas, null);
        EditText nombreVenta = contactPopupView.findViewById(R.id.NombreVenta);
        EditText Cliente = contactPopupView.findViewById(R.id.Cliente);
        EditText PlantillaPresupuesto = contactPopupView.findViewById(R.id.PlantillaPresupuesto);
        EditText Validez = contactPopupView.findViewById(R.id.Validez);
        EditText PlazoDePago = contactPopupView.findViewById(R.id.PlazoDePago);

        Button btnEnviar = contactPopupView.findViewById(R.id.btnSubirProyecto);
        TextView txtclose = contactPopupView.findViewById(R.id.txtclose);

        txtclose.setText("X");
        dialogBuilder.setView(contactPopupView);
        dialog= dialogBuilder.create();
        dialog.show();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nombreVenta.toString().equals("") || Cliente.toString().equals("") || PlantillaPresupuesto.toString().equals("") ||Validez.toString().equals("")||PlazoDePago.toString().equals("")){
                    Snackbar snackbar = Snackbar.make(v, "Algunos de los datos estan vacios" , Snackbar.LENGTH_LONG);
                    snackbar.setDuration(2000);
                    snackbar.show();
                }
                else {
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