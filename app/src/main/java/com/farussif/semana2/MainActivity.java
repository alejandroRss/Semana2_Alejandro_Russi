package com.farussif.semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_Siguiente;
    private EditText et_Nombre;
    private EditText et_Fecha_Nacimiento;
    private EditText et_Telefono;
    private EditText et_Email;
    private EditText et_Descrip;
    private int dia,mes,anio, contador_activity_main;
    protected int contador_global;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_Siguiente = (Button) findViewById(R.id.bt_Sig);
        et_Nombre = (EditText) findViewById(R.id.et_Nombre_Completo);
        et_Fecha_Nacimiento = (EditText) findViewById(R.id.et_Fecha_Nacimiento);
        et_Telefono = (EditText) findViewById(R.id.et_Telefono);
        et_Email = (EditText) findViewById(R.id.et_Mail);
        et_Descrip = (EditText) findViewById(R.id.et_Descrip);

        bt_Siguiente.setOnClickListener(this);
        et_Fecha_Nacimiento.setOnClickListener(this);



        //Bundle parametros = getIntent().getExtras();
        //String nombre = parametros.getString(getResources().getString(R.string.p_edit_nombre));
        //String fecha_nacimiento = parametros.getString(getResources().getString(R.string.p_fecha_nacimiento));
        //String telefono = parametros.getString(getResources().getString(R.string.p_edit_telefono));
        //String email = parametros.getString(getResources().getString(R.string.p_edit_email));
        //String descrip_contacto = parametros.getString(getResources().getString(R.string.p_edit_descrip));

        //et_Nombre.setText(nombre);
        //et_Fecha_Nacimiento.setText(fecha_nacimiento);
        //et_Telefono.setText(telefono);
        //et_Email.setText(email);
        //et_Descrip.setText(descrip_contacto);
    }

    @Override
    public void onClick(View view) {
            if (view==et_Fecha_Nacimiento){
                final Calendar c = Calendar.getInstance();
                dia = c.get(Calendar.DAY_OF_MONTH);
                mes = c.get(Calendar.MONTH);
                anio = c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        et_Fecha_Nacimiento.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                },dia,mes,anio);
                datePickerDialog.show();
            }
            if(view==bt_Siguiente){
                if (et_Nombre.getText().toString().isEmpty()){
                    Toast.makeText(this,"Campo Nombre Vacío",Toast.LENGTH_LONG).show();
                }else {
                    if (et_Fecha_Nacimiento.getText().toString().isEmpty()){
                        Toast.makeText(this,"Campo Fecha de nacimiento Vacío",Toast.LENGTH_LONG).show();

                    }else {
                        if (et_Telefono.getText().toString().isEmpty()){
                            Toast.makeText(this,"Campo Teléfono Vacío",Toast.LENGTH_LONG).show();
                        }else{
                            if (!validarTelefono(et_Telefono.getText().toString())){
                                et_Telefono.setError("Teléfono no válido");

                            }else{
                                if (et_Email.getText().toString().isEmpty()){
                                    Toast.makeText(this,"Campo Mail Vacío",Toast.LENGTH_LONG).show();
                                }else{
                                    if (!validarEmail(et_Email.getText().toString())){
                                        et_Email.setError("Mail no válido");
                                    }else{
                                        if (et_Descrip.getText().toString().isEmpty()){
                                            Toast.makeText(this,"Campo Descripción Contacto Vacío",Toast.LENGTH_LONG).show();
                                        }else{
                                            //Toast.makeText(this,"Datos completos",Toast.LENGTH_LONG).show();

                                            contador_activity_main=1;
                                            Intent intent = new Intent(MainActivity.this,Datos_Contacto2.class);
                                            intent.putExtra(getResources().getString(R.string.p_edit_nombre),et_Nombre.getText().toString());
                                            intent.putExtra(getResources().getString(R.string.p_fecha_nacimiento),et_Fecha_Nacimiento.getText().toString());
                                            intent.putExtra(getResources().getString(R.string.p_edit_telefono),et_Telefono.getText().toString());
                                            intent.putExtra(getResources().getString(R.string.p_edit_email),et_Email.getText().toString());
                                            intent.putExtra(getResources().getString(R.string.p_edit_descrip),et_Descrip.getText().toString());
                                            intent.putExtra("contador",contador_activity_main);
                                            //finish();

                                            startActivity(intent);


                                        }
                                    }


                                }
                            }

                        }
                    }
                }
            }
    }
    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
    private boolean validarTelefono(String telefono) {
        Pattern pattern = Patterns.PHONE;
        return pattern.matcher(telefono).matches();
    }
}