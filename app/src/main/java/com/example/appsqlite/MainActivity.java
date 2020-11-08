package com.example.appsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appsqlite.Utilidades.UtilidadUsuario;

public class MainActivity extends AppCompatActivity {

    UtilidadUsuario.ConexionSQliteHelper con;
    EditText NombreEquipo, Codigo, Meger, Tierra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    con = new UtilidadUsuario.ConexionSQliteHelper(this, "bd_Usuario", null, 1);
        NombreEquipo = (EditText)findViewById(R.id.txtNombreEquipo);
        Codigo = (EditText)findViewById(R.id.txtCodigo);
        Meger = (EditText)findViewById(R.id.txtMeger);
        Tierra = (EditText)findViewById(R.id.txtTierra);
    }

    public void onClick(View view){
        RegistrarUsuario();
        Toast.makeText(getApplicationContext(), "El Usuario Se Ha Registrado", Toast.LENGTH_SHORT).show();
    }

    private void RegistrarUsuario(){
        UtilidadUsuario.ConexionSQliteHelper conn = new UtilidadUsuario.ConexionSQliteHelper(this, "bd_Usuario", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UtilidadUsuario.NombreEquipo, NombreEquipo.getText().toString());
        values.put(UtilidadUsuario.Codigo, Codigo.getText().toString());
        values.put(UtilidadUsuario.Meger, Meger.getText().toString());
        values.put(UtilidadUsuario.Tierra, Tierra.getText().toString());

        long idResultado = db.insert(UtilidadUsuario.Tabla_Usuario,UtilidadUsuario.idEquipo,values);
        Toast.makeText(getApplicationContext(), "Id Registrado" +idResultado, Toast.LENGTH_SHORT).show();
        db.close();
    }
}
