package com.example.project122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
    }

    public void seccionBonos(View v) {

        Intent intent = new Intent(Main_Login.this, Activity_Aterrizaje.class);
        startActivity(intent);
    }

    public void VolverAterrizajee(View v) {

        Intent intent = new Intent(Main_Login.this, MainActivity.class);
        startActivity(intent);
    }
}