package com.example.project122;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Registro extends AppCompatActivity {

    private EditText editTextUsuario;
    private EditText editTextEmail;
    private EditText editTextContraseña;
    private Button buttonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editTextUsuario = findViewById(R.id.editTextTextPersonName4);
        editTextEmail = findViewById(R.id.editTextTextPersonName3);
        editTextContraseña = findViewById(R.id.editTextTextPersonName2);
        buttonRegistrar = findViewById(R.id.but);

        // Agregar evento de click al botón "Registrar"
        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = editTextUsuario.getText().toString();
                String email = editTextEmail.getText().toString();
                String contraseña = editTextContraseña.getText().toString();

                if (usuario.isEmpty() || email.isEmpty() || contraseña.isEmpty()) {
                    Toast.makeText(Activity_Registro.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("GoStreet44/Cliente");


                Cliente cliente = new Cliente(usuario, email, contraseña);


                String clienteId = reference.push().getKey();


                reference.child(clienteId).setValue(cliente);


                Toast.makeText(Activity_Registro.this, "Datos registrados correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }
}