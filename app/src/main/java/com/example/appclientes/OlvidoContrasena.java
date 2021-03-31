package com.example.appclientes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class OlvidoContrasena extends AppCompatActivity {
    private EditText correo, pass1, pass2;
    private Button btnCambiarContra;
    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICACION_ID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvido_contrasena);
        correo = findViewById(R.id.EmailOlvidoContra);
        pass1 = findViewById(R.id.Pass1);
        pass2 = findViewById(R.id.Pass2);
        btnCambiarContra = findViewById(R.id.Validar);

        btnCambiarContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarContra(v);
            }
        });
    }

    public void cambiarContra(View view) {
        if (correo.getText().toString().equals("") || pass1.getText().toString().equals("")|| pass2.getText().toString().equals("")) {
            Snackbar snackbar = Snackbar.make(view, R.string.dastosVaciosLogin, Snackbar.LENGTH_LONG);
            snackbar.setDuration(2000);
            snackbar.show();
        }
        else if(pass1.length()>9){
            Snackbar snackbar = Snackbar.make(view, R.string.pass9caracteres,Snackbar.LENGTH_LONG);
            snackbar.setDuration(2000);
            snackbar.show();
        }
        else if(!pass1.getText().toString().equals(pass2.getText().toString())){
            Snackbar snackbar = Snackbar.make(view, R.string.contrasenas_iguales, Snackbar.LENGTH_LONG);
            snackbar.setDuration(2000);
            snackbar.show();
        }
        else {

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
                            /*Toast.makeText(getApplicationContext(), "Inicio de sesion correcto.",
                                    Toast.LENGTH_SHORT).show();*/
            Snackbar snackbar = Snackbar.make(view, R.string.inicioSesionCorrecto, Snackbar.LENGTH_LONG);
            snackbar.setDuration(2000);
            snackbar.show();
            // Llamamos a los metodos para la creacion del canal para las notificaciones
            setPendingIntent();
             createNotificacionChanel();
             createNotification();

        }
    }
    private void setPendingIntent(){
        Intent intent = new Intent(this, Login.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(OlvidoContrasena.class);
        stackBuilder.addNextIntent(intent);
        pendingIntent = stackBuilder.getPendingIntent(1, PendingIntent.FLAG_CANCEL_CURRENT);
    }
    private void createNotificacionChanel(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            CharSequence name = "Notificacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
    //metodo que crea la notificacion con sus respectivos texto textos
    private void createNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
        //builder.setSmallIcon(R.drawable.ic_persona_perfil);
        builder.setContentTitle("La contraseña fue modificada con exito.");
        builder.setContentText("Recuerda que puedes cambiar tus datos como la contraseña y otros en el perfil.");
        builder.setColor(Color.BLACK);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setLights(Color.GREEN, 1000, 1000);
        builder.setVibrate(new long[]{1000,1000,1000,1000,1000});
        builder.setDefaults(Notification.DEFAULT_SOUND);

        builder.setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID, builder.build());
    }
}