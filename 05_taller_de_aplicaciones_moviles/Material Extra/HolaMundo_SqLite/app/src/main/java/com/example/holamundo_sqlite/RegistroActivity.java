package com.example.holamundo_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.holamundo_sqlite.model.DbHelper;

public class RegistroActivity extends AppCompatActivity {
    EditText txtNombre, txtCorreo, txtPass, txtPass2;
    Button btnRegistro;
    DbHelper bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre=findViewById(R.id.usuario);
        txtCorreo=findViewById(R.id.mail);
        txtPass=findViewById(R.id.pass);
        txtPass2=findViewById(R.id.pass2);
        btnRegistro=findViewById(R.id.registrar);
        bd=new DbHelper(this);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtNombre.getText().toString();
                String correo = txtCorreo.getText().toString();
                String pass = txtPass.getText().toString();
                String pass2 = txtPass2.getText().toString();
                if (nombre.isEmpty() || correo.isEmpty() || pass.isEmpty() || pass2.isEmpty()){
                    Toast.makeText(RegistroActivity.this, "campos vacios", Toast.LENGTH_LONG).show();
                }
                else{
                    if(pass.equals(pass2)){
                        Boolean revisarUsuario = bd.revisarUsuario(nombre);
                        if(revisarUsuario==false){
                            Boolean registro = bd.crearDatos(nombre, correo, pass);
                            if (registro==true){
                                Toast.makeText(RegistroActivity.this, "registro exitoso",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(RegistroActivity.this, "registro fallido",Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(RegistroActivity.this, "usuario existe",Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(RegistroActivity.this, "Contraseña no coincide",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}