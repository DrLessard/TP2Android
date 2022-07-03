package com.mottomotto.android1labo2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String selectedProvince = "";
    int cities = 0;
    Spinner spinner2;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.imageView);
        Spinner spinner1 = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,  R.array.provinces,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String prov = parent.getItemAtPosition(position).toString();
        selectedProvince = prov;

        switch(selectedProvince){
            case "Aucune Selection" : cities = R.array.villes_vide;
            break;
           case "Quebec" : cities = R.array.villes_quebec;
               iv.setImageResource(R.drawable.quebec);

           break;
            case "Ontario": cities = R.array.villes_ontario;
                iv.setImageResource(R.drawable.ontario);
            break;
            case "Alberta": cities = R.array.villes_alberta;
                iv.setImageResource(R.drawable.alberta);
            break;
            default : cities = R.array.villes_vide;
                break;
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, cities, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);


        Toast.makeText(parent.getContext(), prov, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        cities = R.array.villes_vide;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, cities, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);


    }

}