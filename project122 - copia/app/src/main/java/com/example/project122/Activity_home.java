package com.example.project122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeproveedor);
    }

    public void crearBonoss(View v) {

        Intent intent = new Intent(Activity_home.this, Activity_crearbono.class);
        startActivity(intent);
    }

    public void VerBonos(View v) {

        Intent intent = new Intent(Activity_home.this, Activity_seccionbono.class);
        startActivity(intent);
    }

    //crearBonos  VerBonos
}