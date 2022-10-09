package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt1 = findViewById(R.id.textView);
        EditText editTextApellido = findViewById(R.id.eText1);
        EditText editTextNombre=findViewById(R.id.editTextNombre);
        Button btn = findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = editTextNombre.getText().toString();
                String apellido = editTextApellido.getText().toString();

                /*int n1= Integer.parseInt(nombre);
                int n2= Integer.parseInt(apellido);

                txt1.setText("La suma de ambos numeros es: "+String.valueOf(n1+n2));*/
                if (nombre.isEmpty()){
                    txt1.setText("Esta vacio");
                }
                else{
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("key",nombre);
                    MainActivity.this.startActivity(intent);
                }

            }
        });


    }
}