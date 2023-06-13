package com.example.project122;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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

import clases.Bonos;
import clases.Cliente;

public class Activity_crearbono extends AppCompatActivity {


    private EditText editTextFinicio;
    private EditText editTextfechafinal;
    private EditText editTexttiempoinicio;

    private EditText editTextTiempofinal;

    private EditText editTextCantidad;

    private EditText editTextDescuento;

    private EditText editTextPrecio;


    private EditText editTextdescripcion;


    private Button btnRegBonos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearbono);

        editTextFinicio   = (EditText) findViewById(R.id.editTextFinicio);
        editTextfechafinal   = (EditText) findViewById(R.id.editTextfechafinal);
        editTexttiempoinicio   = (EditText) findViewById(R.id.editTexttiempoinicio);

        editTextTiempofinal   = (EditText) findViewById(R.id.editTextTiempofinal);
        editTextCantidad   = (EditText) findViewById(R.id.editTextCantidad);
        editTextDescuento   = (EditText) findViewById(R.id.editTextDescuento);
        editTextPrecio   = (EditText) findViewById(R.id.editTextPrecio);
        editTextdescripcion   = (EditText) findViewById(R.id.editTextdescripcion);

        btnRegBonos  = (Button)   findViewById(R.id.btnRegBonos);

        botonRegistrarbono();
    }

    private void botonRegistrarbono(){
        btnRegBonos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // validacion de ID y nombre en el input
                if (editTextFinicio.getText().toString().trim().isEmpty() //si id o nombre esta vacio Error

                       ){

                    ocultarTeclado();
                    Toast.makeText(Activity_crearbono.this, "Complete los campos faltantes!!", Toast.LENGTH_SHORT).show();
                }else {


                    String Finicio = editTextFinicio.getText().toString(); //← ← ← se captura el texto del luchador ← ← ←
                    String FFin = editTextfechafinal.getText().toString();
                    String Hinicio = editTexttiempoinicio.getText().toString();
                    String Hfinal = editTextTiempofinal.getText().toString();

                    int canti = Integer.parseInt(editTextCantidad.getText().toString());
                    int descuen = Integer.parseInt(editTextDescuento.getText().toString());
                    int prec = Integer.parseInt(editTextPrecio.getText().toString());

                    String descrip = editTextdescripcion.getText().toString();





                    //FIREBASE
                    FirebaseDatabase db = FirebaseDatabase.getInstance(); // ←← conexion a la base de datos
                    DatabaseReference dbref = db.getReference(clases.Bonos.class.getSimpleName()); // ← referencia que coincide con luchador osea que Luchador sea igual a Luchador


                    //evento de accion de firebase
                    dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        // snapshot hace referencia al contenido de la base de datos
                        public void onDataChange(@NonNull DataSnapshot snapshot) { //aqui adentro se define que quieres hacer

                            Bonos luc = new Bonos(Finicio, FFin,Hinicio,Hfinal, canti, descuen, prec, descrip  /*, descuen, prec, , , Hinicio, Hfinal,  descrip*/); //clase hijo del constructor
                            dbref.push().setValue(luc); // aqui se hace el insert osea enviar info a la base de datos
                            ocultarTeclado();
                            Toast.makeText(Activity_crearbono.this, "Luchador registrado correctamente", Toast.LENGTH_SHORT).show();


                            editTextFinicio.setText("");
                            editTextfechafinal.setText("");
                            editTexttiempoinicio.setText("");

                            editTextTiempofinal.setText("");
                            editTextCantidad.setText("");
                            editTextDescuento.setText("");
                            editTextPrecio.setText("");
                            editTextdescripcion.setText("");



                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(Activity_crearbono.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

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


    public void volHomeProveedor2 (View v) {

        Intent intent = new Intent(Activity_crearbono.this, Activity_home.class);
        startActivity(intent);
    }

}