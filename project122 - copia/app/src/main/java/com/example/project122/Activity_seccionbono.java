package com.example.project122;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import clases.AdapterBonos;
import clases.Bonos;

public class Activity_seccionbono extends AppCompatActivity {


    RecyclerView recyclerView;
    DatabaseReference database;
    AdapterBonos adapterBonos;
    ArrayList<Bonos> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccionbono);

        recyclerView = findViewById(R.id.BonosList);
        database = FirebaseDatabase.getInstance().getReference("Bonos");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapterBonos = new AdapterBonos(this,list);
        recyclerView.setAdapter(adapterBonos);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    Bonos bonos = dataSnapshot.getValue(Bonos.class);
                    list.add(bonos);

                }
                adapterBonos.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void VolHomeProveedor(View v) {

        Intent intent = new Intent(Activity_seccionbono.this, Activity_home.class);
        startActivity(intent);
    }
}