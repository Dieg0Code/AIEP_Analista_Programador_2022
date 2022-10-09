package com.example.calculadoraacuenta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Division extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);

        EditText numero1 = findViewById(R.id.etSus);
        EditText numero2= findViewById(R.id.etSus2);
        TextView resultado = findViewById(R.id.tvSus);
        Button btndiv=findViewById(R.id.btnSus);

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    double n1= Double.parseDouble(numero1.getText().toString());
                    double n2= Double.parseDouble(numero2.getText().toString());
                    if(n2!=0){
                        double division=n1/n2;
                        resultado.setText(String.valueOf(division));
                    }
                    else {
                        Toast.makeText(Division.this, "El divisor no puede ser 0 ",Toast.LENGTH_LONG);
                    }
                }catch (NumberFormatException e){ //1
                    Toast.makeText(Division.this, "Ingrese un numero "+e,Toast.LENGTH_LONG); //Muestra un mensaje
                }
            }
        });
    }
}
    }
}