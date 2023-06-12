package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btEnviar(View view){
        EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
        EditText txtApellido = (EditText)findViewById(R.id.txtApellido);
        RadioButton rbFemenino = (RadioButton) findViewById(R.id.rbFemenino);
        RadioButton rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        Switch swNotificaciones= (Switch)findViewById(R.id.swAlerta);
        Calendar calendario = Calendar.getInstance();

        String genero, nombre, apellido, notificaciones;


        nombre=txtNombre.getText().toString();
        apellido=txtApellido.getText().toString();
        notificaciones= swNotificaciones.isChecked()? "SI":"NO";
        genero = "Estimad" +(rbMasculino.isChecked()?"o":"a");
///// calendario= calendario.getBytes().toString();


        Toast.makeText(this.getApplicationContext(),
                "Hola " + genero + " " + nombre +
                apellido + " " + "Notificaciones" + notificaciones,
                Toast.LENGTH_LONG).show();

//para abrir activida- poder cominicarse con la otra actividad//

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);


        //para enviar la informacion a la otra actividad //

        Bundle b = new Bundle();
        b.putString("NOMBRE", nombre);
        b.putString("APELLIDO", apellido);
        b.putString("NOTIFICACIONES", notificaciones);
        b.putString("GENERO", genero);
//Añadimos la información al intent//
        intent.putExtras(b);
        startActivity(intent);



    }
}