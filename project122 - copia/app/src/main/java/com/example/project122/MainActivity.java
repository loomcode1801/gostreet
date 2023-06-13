package com.example.project122;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private ConstraintLayout bottomsheet ;
    private ConstraintLayout bottomsheet2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aterrizaje);
        bottomsheet = findViewById(R.id.botttom_sheet);
        bottomsheet2 = findViewById(R.id.botttom_sheet2);

        bottomsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(true);
            }
        });

        bottomsheet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(false);
            }
        });
    }

    private void showDialog(boolean isBottomSheet1) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        Button clienteButton = dialog.findViewById(R.id.clip_cliente);
        Button proveedorButton = dialog.findViewById(R.id.clip_Proveeedor);

        if (isBottomSheet1) {
            clienteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, "Cliente seleccionado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Main_Login.class);
                    startActivity(intent);
                }
            });

            proveedorButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, "Proveedor seleccionado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, LoginProveedorrr.class);
                    startActivity(intent);
                }
            });
        } else {
            clienteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, "Cliente seleccionado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Activity_Registro.class);
                    startActivity(intent);
                }
            });

            proveedorButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, "Proveedor seleccionado", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, RegistroProveedor_Activity.class);
                    startActivity(intent);
                }
            });
        }

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }


}