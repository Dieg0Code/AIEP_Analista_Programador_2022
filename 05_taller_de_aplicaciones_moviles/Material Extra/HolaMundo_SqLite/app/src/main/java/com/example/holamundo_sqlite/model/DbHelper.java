package com.example.holamundo_sqlite.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public String DBNAME="login.db";
    public DbHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(nombre TEXT primary key, correo TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists usuarios");
    }

    public Boolean crearDatos(String usuario, String email, String password){
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("usuario",usuario);
        valores.put("correo",email);
        valores.put("password",password);

        long resultado = bd.insert("usuarios",null,valores);
        if(resultado==-1){
            return false;
        }
        else{
          return true;
        }
    }
    public Boolean revisarUsuario(String usuario){
        SQLiteDatabase bd =this.getWritableDatabase();
        Cursor cursor = bd.rawQuery("select * from usuarios where usuario=?",new String[]{usuario});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean login(String usuario, String password){
        SQLiteDatabase bd =this.getWritableDatabase();
        Cursor cursor = bd.rawQuery("select * from usuarios where usuario=? and password=?",new String[]{usuario, password});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
}
