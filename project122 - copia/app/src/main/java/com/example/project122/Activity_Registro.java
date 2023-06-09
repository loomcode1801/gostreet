package com.example.project122;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import clases.Cliente;

public class Activity_Registro extends AppCompatActivity {

    //variables
    private EditText txtClienteID, txtClienteNom, txtClienteEmail, txtClientePassword;

    private Button btnRegClient;

    private ListView lvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtClienteID   = (EditText) findViewById(R.id.txtClienteID);
        txtClienteNom  = (EditText) findViewById(R.id.txtClienteNom);
        txtClienteEmail  = (EditText) findViewById(R.id.txtClienteEmail);
        txtClientePassword  = (EditText) findViewById(R.id.txtClientePassword);

        btnRegClient  = (Button)   findViewById(R.id.btnRegClient);

        botonRegistrar();
    }// cierra el on create



    private void botonRegistrar(){
        btnRegClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // validacion de ID y nombre en el input
                if (txtClienteID.getText().toString().trim().isEmpty() //si id o nombre esta vacio Error
                        || txtClienteNom.getText().toString().trim().isEmpty()
                        || txtClienteEmail.getText().toString().trim().isEmpty()
                        || txtClientePassword.getText().toString().trim().isEmpty()){

                    ocultarTeclado();
                    Toast.makeText(Activity_Registro.this, "Complete los campos faltantes!!", Toast.LENGTH_SHORT).show();
                }else {


                    int id = Integer.parseInt(txtClienteID.getText().toString()); // ← ← se convierte la id de string a int
                    String nom = txtClienteNom.getText().toString(); //← ← ← se captura el texto del luchador ← ← ←
                    String email = txtClienteEmail.getText().toString();
                    String passw = txtClientePassword.getText().toString();


                    //FIREBASE
                    FirebaseDatabase db = FirebaseDatabase.getInstance(); // ←← conexion a la base de datos
                    DatabaseReference dbref = db.getReference(Cliente.class.getSimpleName()); // ← referencia que coincide con luchador osea que Luchador sea igual a Luchador



                    //evento de accion de firebase
                    dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override         // snapshot hace referencia al contenido de la base de datos
                        public void onDataChange(@NonNull DataSnapshot snapshot) { //aqui adentro se define que quieres hacer

                            Cliente luc = new Cliente(id, nom, email, passw); //clase hijo del constructor
                            dbref.push().setValue(luc); // aqui se hace el insert osea enviar info a la base de datos
                            ocultarTeclado();
                            Toast.makeText(Activity_Registro.this, "Luchador registrado correctamente", Toast.LENGTH_SHORT).show();
                            txtClienteID.setText("");
                            txtClienteNom.setText("");
                            txtClienteEmail.setText("");
                            txtClientePassword.setText("");
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(Activity_Registro.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                        }
                    });

                } // cierra el if/else inicial

            }
        });
    }// cierra el metodo boton registrar






    // Cierra el método ocultarTeclado.
    private void ocultarTeclado(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    } // Cierra el método ocultarTeclado.

}