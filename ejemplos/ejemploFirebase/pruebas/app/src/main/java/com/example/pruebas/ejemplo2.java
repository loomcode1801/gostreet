package com.example.pruebas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ejemplo2 extends AppCompatActivity {

    private TextView mTextViewData;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo2);

        mTextViewData = (TextView) findViewById(R.id.mTextViewData);

        mDatabase = FirebaseDatabase.getInstance().getReference(); //nodo principal de la base de datos

        mDatabase.child("Luchador").addValueEventListener(new ValueEventListener() { // tabña Luchador
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /*if (snapshot.exists()){
                    String nombre = snapshot.child("nombre").getValue().toString();
                    mTextViewData.setText("El nombre es: " + nombre);
                }*/


                String nombre = "";
                DataSnapshot nombreSnapshot = snapshot.child("nombre");
                if (nombreSnapshot.exists() && nombreSnapshot.getValue() != null) {
                    nombre = nombreSnapshot.getValue().toString();

                    mTextViewData.setText("El nombre es: " + nombre);
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



}