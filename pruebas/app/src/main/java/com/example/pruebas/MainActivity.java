package com.example.pruebas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;




public class MainActivity extends AppCompatActivity {

    Button btnMostrarModal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMostrarModal = findViewById(R.id.btn_modal);

        btnMostrarModal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { mostrar(); }
        });
    }

    public void mostrar() {

        //posible solucion a el tema de los tamaños
        /*    ↓
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        *///  ↑

        View popupView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.modal_ejemplo,null,false);
        final PopupWindow popupWindow = new PopupWindow(popupView, 800, 500,false);
        popupWindow.showAtLocation(btnMostrarModal, Gravity.CENTER,0 , 0);

        popupView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { popupWindow.dismiss();}
        });
    }


}




//ejemplo2
/*
public class MainActivity extends AppCompatActivity {

    Button popupBTN;
    Dialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popupBTN = findViewById((R.id.btn_modal));
        mDialog = new Dialog(this);

        popupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.setContentView(R.layout.popup);

                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
        });


    }


}
*/