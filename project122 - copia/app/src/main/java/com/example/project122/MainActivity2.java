package com.example.project122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void VolverAterrizaje(View v) {

        Intent intent = new Intent(MainActivity2.this, Activity_Aterrizaje.class);
        startActivity(intent);
    }
}