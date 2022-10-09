package com.example.calculadoraacuenta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Resta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resta);

        EditText numero1 = findViewById(R.id.etSus);
        EditText numero2= findViewById(R.id.etSus2);
        TextView resultado = findViewById(R.id.tvSus);
        Button btnsus=findViewById(R.id.btnSus);

        btnsus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    double n1= Double.parseDouble(numero1.getText().toString());
                    double n2= Double.parseDouble(numero2.getText().toString());
                    double resta=n1-n2;
                    resultado.setText(String.valueOf(resta));
                }catch (NumberFormatException e){ //1
                    Toast.makeText(Resta.this, "Ingrese un numero "+e,Toast.LENGTH_LONG); //Muestra un mensaje
                }
            }
        });
    }
}