package com.example.appclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.toolbox.JsonArrayRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class PartesHoras extends AppCompatActivity {
    private FloatingActionButton buscar, insertar;
    private EditText fechainico;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    List<ListView> PartesHoras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partes_horas);
        insertar = findViewById(R.id.InsertarParteHora);

    //    obtenerPublicaciones(ConexionCAD.mostarPartesHoras());

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup(v);
            }
        });
    }
    public void obtenerPublicaciones(String url){
        //JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,)
    }
    public void ShowPopup(View v) {
        dialogBuilder= new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.popup, null);
        EditText editarNombre = contactPopupView.findViewById(R.id.Proyecto);
        EditText editartelefono = contactPopupView.findViewById(R.id.Estado);
        EditText editarpuesto = contactPopupView.findViewById(R.id.SeleccionarEmpresa);
        EditText HoraInicio = contactPopupView.findViewById(R.id.PlantillaPresupuesto);
        EditText horaFinal = contactPopupView.findViewById(R.id.Validez);

        Button btnEnviar = contactPopupView.findViewById(R.id.btnSubirProyecto);
        TextView txtclose = contactPopupView.findViewById(R.id.txtclose);

        txtclose.setText("X");
        dialogBuilder.setView(contactPopupView);
        dialog= dialogBuilder.create();
        dialog.show();
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editarNombre.getText().toString().equals("") || editarpuesto.getText().toString().equals("") || editartelefono.getText().toString().equals("")|| HoraInicio.getText().toString().equals("")|| horaFinal.getText().toString().equals("")){
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
    public void showDatePickerDialog(){
        //todo Crear el metodo para el datepicker

    }

}