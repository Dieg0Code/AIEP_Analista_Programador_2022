package com.example.calculadoraacuenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        EditText txt = findViewById(R.id.operacion);
        Button btn = findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Esta vacío",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(txt.getText().toString().equals("Suma")){
                        Intent intent = new Intent(MainActivity.this, Suma.class);
                        MainActivity.this.startActivity(intent);
                    }
                    if(txt.getText().toString().equals("Resta")){
                        Intent intent = new Intent(MainActivity.this, Resta.class);
                        MainActivity.this.startActivity(intent);
                    }
                    if(txt.getText().toString().equals("Division")){
                        Intent intent = new Intent(MainActivity.this, Division.class);
                        MainActivity.this.startActivity(intent);
                    }
                    if(txt.getText().toString().equals("Multiplicacion")){
                        Intent intent = new Intent(MainActivity.this, Multiplicacion.class);
                        MainActivity.this.startActivity(intent);
                    }
                }
            }
        });
    }
}