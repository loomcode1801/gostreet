package com.example.pruebas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private EditText txtid, txtnom;
    private Button btnbus, btnmod, btnreg, btneli;
    private ListView lvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //codigo
        txtid   = (EditText) findViewById(R.id.txtid);
        txtnom  = (EditText) findViewById(R.id.txtnom);
        btnbus  = (Button)   findViewById(R.id.btnbus);
        btnmod  = (Button)   findViewById(R.id.btnmod);
        btnreg  = (Button)   findViewById(R.id.btnreg);
        btneli  = (Button)   findViewById(R.id.btneli);
        lvDatos = (ListView) findViewById(R.id.lvDatos);

        botonBuscar();
        botonModificar();
        botonRegistrar();
        botonEliminar();

        listarLuchadores();

    }// cierra el on create

    private void botonBuscar(){}





    private void botonModificar(){}






    private void botonRegistrar(){
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // validacion de ID y nombre en el input
                if (txtid.getText().toString().trim().isEmpty()
                || txtnom.getText().toString().trim().isEmpty()){

                    ocultarTeclado();
                    Toast.makeText(MainActivity.this, "Complete los campos faltantes!!", Toast.LENGTH_SHORT).show();
                }else {


                    int id = Integer.parseInt(txtid.getText().toString()); // ← ← se convierte la id de string a int
                    String nom = txtnom.getText().toString(); //← ← ← se captura el texto del luchador ← ← ←



                    //FIREBASE
                    FirebaseDatabase db = FirebaseDatabase.getInstance(); // ←← conexion a la base de datos
                    DatabaseReference dbref = db.getReference(Luchador.class.getSimpleName()); // ← referencia que coincide con luchador osea que Luchador sea igual a Luchador



                    //evento de accion de firebase
                    dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) { //aqui adentro se define que quieres hacer


                            String aux = Integer.toString(id); // convierte el id a un String
                            boolean res = false;
                            for (DataSnapshot x : snapshot.getChildren()){
                                if (x.child("id").getValue().toString().equalsIgnoreCase(aux)){
                                    res = true;
                                    ocultarTeclado();
                                    Toast.makeText(MainActivity.this, "Error el id ("+aux+") ya existe", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }

                            boolean res2 = false;
                            for (DataSnapshot x : snapshot.getChildren()){
                                if (x.child("nombre").getValue().toString().equalsIgnoreCase(nom)){
                                    res2 = true;
                                    ocultarTeclado();
                                    Toast.makeText(MainActivity.this, "Error el nombre ya existe", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }



                            if (res == false && res2 == false){
                                Luchador luc = new Luchador(id, nom); //clase hijo del constructor
                                dbref.push().setValue(luc); // aqui se hace el insert osea enviar info a la base de datos
                                ocultarTeclado();
                                Toast.makeText(MainActivity.this, "Luchador registrado correctamente", Toast.LENGTH_SHORT).show();
                                txtid.setText("");
                                txtnom.setText("");
                            }


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(MainActivity.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                        }
                    });

                } // cierra el if/else inicial

            }
        });
    }// cierra el metodo boton registrar

    private void listarLuchadores(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference dbref = db.getReference(Luchador.class.getSimpleName());

        ArrayList <Luchador> lisluc = new ArrayList<Luchador> ();
        ArrayAdapter <Luchador> ada = new ArrayAdapter<Luchador>(MainActivity.this, android.R.layout.simple_list_item_1, lisluc);
        lvDatos.setAdapter(ada);

        dbref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Luchador luc = snapshot.getValue(Luchador.class);
                lisluc.add(luc);
                ada.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                ada.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }// cierra el metodo listarLuchadores




    private void botonEliminar(){}








    private void ocultarTeclado(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    } // Cierra el método ocultarTeclado.


    public void navegar (View view){
        Intent miIntent =new Intent(MainActivity.this,ejemplo2.class);
        startActivity(miIntent);
    }

    public void pantalla2 (View view){
        Intent miIntent =new Intent(MainActivity.this,userList.class);
        startActivity(miIntent);
    }




} // cierra la clase



