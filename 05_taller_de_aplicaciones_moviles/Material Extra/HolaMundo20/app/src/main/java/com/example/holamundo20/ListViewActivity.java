package com.example.holamundo20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listaPaises = findViewById(R.id.lista);

        ArrayList<String> paises = new ArrayList<>();
        paises.add("Afghanistan");
        paises.add("Chile");
        paises.add("Peru");
        paises.add("Australia");

        ArrayAdapter<String> paisesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                paises
        );

        listaPaises.setAdapter(paisesAdapter);

        listaPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}