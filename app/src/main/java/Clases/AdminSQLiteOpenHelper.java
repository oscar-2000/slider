package Clases;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{


    //CONSTRUCTOR DE BASE DE DATOS
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    //DEFINO CONFIGURACION INICIAL DE BASE DE DATOS
    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREAR TABLA
        db.execSQL("CREATE TABLE insumos (codigo int primary key, nombre text, precio float, stock int)");

        //INSERTAR

        //ACTUALIZAR

        //ELIMINAR
    }


    //METODO DONDE SE IMPLEMENTA LOS CAMBIOS DE MI BASE DE DATOS
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
