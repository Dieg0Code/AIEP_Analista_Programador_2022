package com.example.calculadoraacuenta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Suma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma2);

        EditText numero1 = findViewById(R.id.etNumeros);
        EditText numero2= findViewById(R.id.editTextTextPersonName2);
        TextView resultado = findViewById(R.id.tvSus);
        Button btnsuma=findViewById(R.id.btnSuma);

        btnsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    double n1= Double.parseDouble(numero1.getText().toString());
                    double n2= Double.parseDouble(numero2.getText().toString());
                    double suma=n1+n2;
                    resultado.setText(String.valueOf(suma));
                }catch (NumberFormatException e){ //1
                    Toast.makeText(Suma.this, "Ingrese un numero "+e,Toast.LENGTH_LONG); //Muestra un mensaje
                }
            }
        });
    }
}
//1- NullPointerException es un tipo de excepcion que se utiliza para evitar que cuando el
//usuario ingrese un String que no pueda ser convertido a ningun tipo numerico (Ej: frase/letra/oracion)
//se caiga el sistema.