package com.example.appclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Adminstrador extends AppCompatActivity {
    private Button btnCrearUsuario, btnEliminarUsuario, btnModificarUsuario,btnInsertarPartesHoras,btnBorrarPartesHoras, btnBorrarProyectos, btnMostraproyectos, btnInsertarProyectos;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminstrador);
        /**Todos los id de los botones  de administrador y su respectivos set onclickListener */
        btnCrearUsuario= findViewById(R.id.btnInsertarUsuario);
        btnEliminarUsuario= findViewById(R.id.btnBorrarUsuario);
        btnInsertarPartesHoras = findViewById(R.id.InsertarParteHoras);
        btnBorrarPartesHoras = findViewById(R.id.BorrarParteHoras);
        btnBorrarProyectos = findViewById(R.id.btnBorrarProyectos);
        btnMostraproyectos = findViewById(R.id.btnMostarProyectos);
        btnInsertarProyectos = findViewById(R.id.btnInsertarProyectos);
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
        btnInsertarPartesHoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopupInsertarParteHoras(v);
            }
        });
        btnBorrarPartesHoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopupBorrarParteHoras(v);
            }
        });
        btnBorrarProyectos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopupBorrarProyectos(v);
            }
        });
        btnMostraproyectos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPoupMostrarProyectos(v);
            }
        });
        btnInsertarProyectos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopUpInsertarProyectos(v);
            }
        });
    }

/**PopUp para la creacion de usuario mediante la cuentea de admintrador. */
    public void ShowPopup(View v) {

        dialogBuilder= new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.pop_up_insertarusuario_administrador, null);
        EditText crearNombre = contactPopupView.findViewById(R.id.Proyecto);
        EditText contrasena = contactPopupView.findViewById(R.id.Estado);
        Button btnEnviar = contactPopupView.findViewById(R.id.btnSubirProyecto);
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
        EditText EliminarUsuarioNombre = contactPopupView.findViewById(R.id.Proyecto);
        EditText EliminarContrasenaUsuairo = contactPopupView.findViewById(R.id.Estado);
        Button btnEnviar = contactPopupView.findViewById(R.id.btnSubirProyecto);
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
        public void ShowPopupInsertarParteHoras(View v){
            dialogBuilder= new AlertDialog.Builder(this);
            final View contactPopupView = getLayoutInflater().inflate(R.layout.pop_up_insertar_parte_horas_administrador, null);
            EditText FechaInicio = contactPopupView.findViewById(R.id.Proyecto);
            EditText FechaFinal = contactPopupView.findViewById(R.id.Estado);
            EditText SeleccionarProyecto = contactPopupView.findViewById(R.id.SeleccionarProyecto);
            EditText SelecionarTareas = contactPopupView.findViewById(R.id.SelecionarTarea);
            EditText Horas = contactPopupView.findViewById(R.id.Horas);
            EditText DescripcionCorta = contactPopupView.findViewById(R.id.Descripcion);

            Button btnEnviar = contactPopupView.findViewById(R.id.btnSubirProyecto);
            TextView txtclose = contactPopupView.findViewById(R.id.txtclose);

            txtclose.setText("X");
            dialogBuilder.setView(contactPopupView);
            dialog= dialogBuilder.create();
            dialog.show();

            btnEnviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(FechaInicio.getText().toString().equals("")|| FechaFinal.getText().toString().equals("")|| SeleccionarProyecto.getText().toString().equals("")|| SelecionarTareas.getText().toString().equals("")|| Horas.getText().toString().equals("")){
                        Snackbar snackbar = Snackbar.make(v, "Los datos estan vacios.",Snackbar.LENGTH_LONG);
                        snackbar.setDuration(2000);
                        snackbar.show();
                    }
                    else{
                        //todo: Hacer la insercion de datos dentro de la base de datos de postgre
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
        public void ShowPopupBorrarParteHoras(View v){
            dialogBuilder= new AlertDialog.Builder(this);
            final View contactPopupView = getLayoutInflater().inflate(R.layout.pop_up_borrar_parte_horas, null);
            EditText empleados = contactPopupView.findViewById(R.id.Proyecto);
            EditText horas = contactPopupView.findViewById(R.id.Estado);
            EditText SeleccionarProyecto = contactPopupView.findViewById(R.id.SeleccionarProyecto);
            EditText SelecionarTareas = contactPopupView.findViewById(R.id.SelecionarTarea);

            Button btnEnviar = contactPopupView.findViewById(R.id.btnSubirProyecto);
            TextView txtclose = contactPopupView.findViewById(R.id.txtclose);

            txtclose.setText("X");
            dialogBuilder.setView(contactPopupView);
            dialog= dialogBuilder.create();
            dialog.show();
            btnEnviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(empleados.getText().toString().equals("")||horas.getText().toString().equals("")||SeleccionarProyecto.getText().toString().equals("")||SelecionarTareas.getText().toString().equals("")){
                        Snackbar snackbar = Snackbar.make(v, "Los datos estan vacios.",Snackbar.LENGTH_LONG);
                        snackbar.setDuration(2000);
                        snackbar.show();
                    }
                    else{
                        //todo Hacer el borrado en la base de datos de postgre
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
        public void ShowPopupBorrarProyectos(View v){
            dialogBuilder= new AlertDialog.Builder(this);
            final View contactPopupView = getLayoutInflater().inflate(R.layout.pop_up_borrar_proyecto_administrador, null);
            EditText Proyecto = contactPopupView.findViewById(R.id.Proyecto);

            Button btnEnviar = contactPopupView.findViewById(R.id.btnSubirProyecto);
            TextView txtclose = contactPopupView.findViewById(R.id.txtclose);

            txtclose.setText("X");
            dialogBuilder.setView(contactPopupView);
            dialog= dialogBuilder.create();
            dialog.show();
            btnEnviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Proyecto.getText().toString().equals("")){
                        Snackbar snackbar = Snackbar.make(v, "Los datos estan vacios.", Snackbar.LENGTH_LONG);
                        snackbar.setDuration(2000);
                        snackbar.show();
                    }
                    else{
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
        public void ShowPoupMostrarProyectos(View v){
            Intent i = new Intent(getApplicationContext(), Proyectos.class);
            startActivity(i);
        }
        public void ShowPopUpInsertarProyectos(View v){
            dialogBuilder= new AlertDialog.Builder(this);
            final View contactPopupView = getLayoutInflater().inflate(R.layout.pop_up_meter_proyecto_administrador, null);
            EditText Proyecto = contactPopupView.findViewById(R.id.Proyecto);
            EditText Estado = contactPopupView.findViewById(R.id.Estado);
            Button btnEnviar = contactPopupView.findViewById(R.id.btnSubirProyecto);
            TextView txtclose = contactPopupView.findViewById(R.id.txtclose);

            txtclose.setText("X");
            dialogBuilder.setView(contactPopupView);
            dialog= dialogBuilder.create();
            dialog.show();

            btnEnviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Proyecto.getText().toString().equals("")||Estado.getText().toString().equals("")){
                        Snackbar snackbar = Snackbar.make(v, "Todos los parametros deben estar completos.", Snackbar.LENGTH_LONG);
                    }
                    else{
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