package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class insumos_act extends AppCompatActivity {

    private EditText edtcodigo, edtnombre, edtprecio, edtstock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos_act);
        edtcodigo = (EditText)findViewById(R.id.edtCodigo);
        edtprecio = (EditText)findViewById(R.id.edtPrecio);
        edtnombre = (EditText)findViewById(R.id.edtNombre);
        edtstock = (EditText)findViewById(R.id.edtStock);
    }

    public void AñadirInsumos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //PERMITE DAR PERMISOS DE ESCRITURA SOBRE LA DB
        if(!edtcodigo.getText().toString().isEmpty()){
            ContentValues cont = new ContentValues();
            cont.put("codigo", edtcodigo.getText().toString());
            cont.put("nombre", edtnombre.getText().toString());
            cont.put("precio", edtprecio.getText().toString());
            cont.put("stock", edtstock.getText().toString());
            db.insert("insumos",null,cont);
            db.close();
            Toast.makeText(this,"Has guardado un insumo",Toast.LENGTH_LONG).show();
            edtcodigo.setText("");
            edtnombre.setText("");
            edtprecio.setText("");
            edtstock.setText("");
      }
        else
            Toast.makeText(this,"Debe ingresar el codigo del insumo", Toast.LENGTH_LONG).show();
    }

    public void MostrarInsumos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //PERMITE DAR PERMISOS DE ESCRITURA SOBRE LA DB
        String codigo = edtcodigo.getText().toString();
        if(!codigo.isEmpty()){
            Cursor fila = db.rawQuery("SELECT nombre, precio, stock FROM insumos WHERE codigo="+codigo,null);
            if(fila.moveToFirst()){    //SI NO HAY CAMPOS DEVUELVE VACIO
                edtnombre.setText(fila.getString(0));
                edtprecio.setText(fila.getString(1));
                edtstock.setText(fila.getString(2));
            }
            else{
                Toast.makeText(this,"No hay campos en la tabla insumos",Toast.LENGTH_LONG).show();
            }

        }
        else{
            Toast.makeText(this,"No hay insumo con el codigo asociado",Toast.LENGTH_LONG).show();
        }
    }

    public void ActualizarInsumos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //PERMITE DAR PERMISOS DE ESCRITURA SOBRE LA DB
        String codigo = edtcodigo.getText().toString();

        ContentValues cont = new ContentValues();
        cont.put("codigo",edtcodigo.getText().toString());
        cont.put("precio",edtprecio.getText().toString());
        cont.put("nombre",edtnombre.getText().toString());
        cont.put("stock",edtstock.getText().toString());

        if(!codigo.isEmpty()){
            db.update("insumos",cont,"codigo="+codigo,null);
            db.close();
            Toast.makeText(this,"Se ha actualizado",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"No se ha podido actualizar",Toast.LENGTH_LONG).show();
        }
    }

    public void EliminarInsumos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //PERMITE DAR PERMISOS DE ESCRITURA SOBRE LA DB
        String codigo = edtcodigo.getText().toString();
        if(!codigo.isEmpty()) {
            db.delete("insumos","codigo="+codigo,null);
            db.close();
            Toast.makeText(this,"Has eliminado un producto",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"No se ha podido eliminar el producto",Toast.LENGTH_LONG).show();
        }
    }
}