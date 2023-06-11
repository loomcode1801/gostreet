package com.example.project122;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class bottomsheetlayout extends AppCompatActivity {
    private Button btn_cliente, btn_proveedor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomsheetlayout);
        btn_cliente=findViewById(R.id.clip_cliente);
        btn_proveedor=findViewById(R.id.clip_Proveeedor);

    }

    public void Ir_a_Registro_cliente(View view){
        Intent miIntent =new Intent( bottomsheetlayout.this,Activity_Registro.class);
        startActivity(miIntent);
    }

    public void Ir_a_Registro_Proveedor(View view){
        Intent miIntent =new Intent( bottomsheetlayout.this,RegistroProveedor_Activity.class);
        startActivity(miIntent);
    }

}
