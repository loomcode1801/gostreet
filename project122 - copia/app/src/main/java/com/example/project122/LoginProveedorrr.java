package com.example.project122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginProveedorrr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_proveedorrr);
    }

    //HomeProveedor

    public void HomeProveedor(View v) {

        Intent intent = new Intent(LoginProveedorrr.this, Activity_home.class);
        startActivity(intent);
    }
}