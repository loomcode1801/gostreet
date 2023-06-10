package com.example.project122;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegistroProveedor_Activity extends AppCompatActivity {

    private EditText txtProveedorID, txtProveedorUser, txtProveedorEmail, txtProveedorPassword,
    txtDireccion, txtDocumento, txtNit, txtRazonSocial, txtTelefono;

    private Button btnRegProveedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_proveedor);

        txtProveedorUser   = (EditText) findViewById(R.id.txtProveedorUser);
        txtProveedorEmail  = (EditText) findViewById(R.id.txtProveedorEmail);
        txtProveedorPassword  = (EditText) findViewById(R.id.txtProveedorPassword);
        txtDireccion  = (EditText) findViewById(R.id.txtDireccion);
        txtDocumento  = (EditText) findViewById(R.id.txtDocumento);
        txtRazonSocial  = (EditText) findViewById(R.id.txtRazonSocial);
        txtTelefono  = (EditText) findViewById(R.id.txtTelefono);

        btnRegProveedor  = (Button)   findViewById(R.id.btnRegProveedor);
    }


}