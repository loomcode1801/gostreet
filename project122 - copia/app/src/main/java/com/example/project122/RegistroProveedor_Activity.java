package com.example.project122;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import clases.Cliente;
import clases.Proveedor;

public class RegistroProveedor_Activity extends AppCompatActivity {

    private EditText txtProveedorUserr, txtProveedorEmail, txtProveedorPassword,
    txtDireccion, txtDocumento, txtRazonSocial, txtTelefono;

    private Button btnRegProveedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_proveedor);

        txtProveedorUserr   = (EditText) findViewById(R.id.txtProveedorUserr);
        txtProveedorEmail  = (EditText) findViewById(R.id.txtProveedorEmail);
        txtProveedorPassword  = (EditText) findViewById(R.id.txtProveedorPassword);
        txtDireccion  = (EditText) findViewById(R.id.txtDireccion);
        txtDocumento  = (EditText) findViewById(R.id.txtDocumento);
        txtRazonSocial  = (EditText) findViewById(R.id.txtRazonSocial);
        txtTelefono  = (EditText) findViewById(R.id.txtTelefono);

        btnRegProveedor  = (Button)   findViewById(R.id.btnRegProveedor);

        botonProveedor();
    }


    private void botonProveedor(){
        btnRegProveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // validacion de ID y nombre en el input
                if (txtProveedorUserr.getText().toString().trim().isEmpty() //si id o nombre esta vacio Error
                        || txtProveedorEmail.getText().toString().trim().isEmpty()
                        || txtProveedorPassword.getText().toString().trim().isEmpty()
                        || txtDireccion.getText().toString().trim().isEmpty()
                ){

                    ocultarTeclado();
                    Toast.makeText(RegistroProveedor_Activity.this, "Complete los campos faltantes!!", Toast.LENGTH_SHORT).show();
                }else {



                    String userProve = txtProveedorUserr.getText().toString(); //← ← ← se captura el texto del luchador ← ← ←
                    String emailProve = txtProveedorEmail.getText().toString();
                    String passwProve = txtProveedorPassword.getText().toString();

                    String direcProve = txtDireccion.getText().toString();
                    String documProve = txtDocumento.getText().toString();
                    String razonProve = txtRazonSocial.getText().toString();
                    String telProve = txtTelefono.getText().toString();


                    //FIREBASE
                    FirebaseDatabase db = FirebaseDatabase.getInstance(); // ←← conexion a la base de datos
                    DatabaseReference dbref = db.getReference(clases.Proveedor.class.getSimpleName()); // ← referencia que coincide con luchador osea que Luchador sea igual a Luchador



                    //evento de accion de firebase
                    dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override         // snapshot hace referencia al contenido de la base de datos
                        public void onDataChange(@NonNull DataSnapshot snapshot) { //aqui adentro se define que quieres hacer

                            Proveedor luc = new Proveedor(userProve, emailProve, passwProve, direcProve, documProve, razonProve, telProve); //clase hijo del constructor
                            dbref.push().setValue(luc); // aqui se hace el insert osea enviar info a la base de datos
                            ocultarTeclado();
                            Toast.makeText(RegistroProveedor_Activity.this, "Luchador registrado correctamente", Toast.LENGTH_SHORT).show();
                            txtProveedorUserr.setText("");
                            txtProveedorEmail.setText("");
                            txtProveedorPassword.setText("");
                            txtDireccion.setText("");
                            txtDocumento.setText("");
                            txtRazonSocial.setText("");
                            txtTelefono.setText("");
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(RegistroProveedor_Activity.this, "Error al guardar", Toast.LENGTH_SHORT).show();
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