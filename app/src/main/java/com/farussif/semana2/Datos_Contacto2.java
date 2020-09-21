package com.farussif.semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;



public class Datos_Contacto2 extends AppCompatActivity implements OnClickListener{

    private Button bt_Siguiente2;
    private TextView tv_Nombre;
    private TextView tv_Fecha_Nacimiento;
    private TextView tv_Telefono;
    private TextView tv_Email;
    private TextView tv_Descrip;
    private int contador_activity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos__contacto2);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.p_edit_nombre));
        String fecha_nacimiento = parametros.getString(getResources().getString(R.string.p_fecha_nacimiento));
        String telefono = parametros.getString(getResources().getString(R.string.p_edit_telefono));
        String email = parametros.getString(getResources().getString(R.string.p_edit_email));
        String descrip_contacto = parametros.getString(getResources().getString(R.string.p_edit_descrip));

        tv_Nombre = (TextView) findViewById(R.id.tv_Nombre_Completo);
        tv_Fecha_Nacimiento = (TextView) findViewById(R.id.tv_Fecha_Nacimiento);
        tv_Telefono = (TextView) findViewById(R.id.tv_Telefono);
        tv_Email = (TextView) findViewById(R.id.tv_Mail);
        tv_Descrip = (TextView) findViewById(R.id.tv_Descrip);
        bt_Siguiente2 = (Button) findViewById(R.id.bt_Sig2);

        tv_Nombre.setText(nombre);
        tv_Fecha_Nacimiento.setText(fecha_nacimiento);
        tv_Telefono.setText(telefono);
        tv_Email.setText(email);
        tv_Descrip.setText(descrip_contacto);

        bt_Siguiente2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        finish();


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){


            finish();


        }

        return super.onKeyDown(keyCode, event);
    }
}