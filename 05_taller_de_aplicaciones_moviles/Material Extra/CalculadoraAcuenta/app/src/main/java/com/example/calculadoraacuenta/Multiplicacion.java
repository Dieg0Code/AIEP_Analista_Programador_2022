package com.example.calculadoraacuenta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Multiplicacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicacion);

        EditText txt1 = findViewById(R.id.etSus2);
        EditText txt2 = findViewById(R.id.etSus);
        TextView resultado = findViewById(R.id.tvSus);
        Button btnmult = findViewById(R.id.btnSus);

        btnmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    double n1= Double.parseDouble(txt1.getText().toString());
                    double n2= Double.parseDouble(txt2.getText().toString());
                    double mult=n1*n2;
                    resultado.setText(String.valueOf(mult));
                }catch (NumberFormatException e){
                    Toast.makeText(Multiplicacion.this, "Ingrese un numero "+e,Toast.LENGTH_LONG); //Muestra un mensaje
                }
            }
        });
    }
}

