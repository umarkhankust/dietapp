package com.example.dietapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "diet.sqlite";
    // Table Name
    private static final String TABLE_NAME = "diet_table";


    private static final String COL_1 = "ID";
    private static final String COL_2 = "food";

    private static final String COL_3 = "disease";
    private static final String COL_4 = "bmi";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,food TEXT,disease TEXt,bmi REAL)");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public boolean insertData( String food, String disease,float bmi ) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        contentValues.put(COL_2, food);
        contentValues.put(COL_3 ,disease);
        contentValues.put(COL_4 ,bmi);

        // insert row
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result==-1){
            return false;
        }
        else{
            Log.d("jjj",contentValues.toString());
            return true;
        }


    }

    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData( int id,String food, String disease,float bmi) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        contentValues.put(COL_1,id);
        contentValues.put(COL_2, food);
        contentValues.put(COL_3 ,disease);
        contentValues.put(COL_4 ,bmi);


        // updating row
         db.update(TABLE_NAME,contentValues,"id=?",new String[]{String.valueOf(id)});
         return true;
    }




    public Integer deleteData( String id ) {
        SQLiteDatabase db = this.getWritableDatabase();

       return db.delete(TABLE_NAME, "Id = ?", new String[]{String.valueOf(String.valueOf(id))});


    }

    public void deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        // db.delete(TABLE_NAME,null,null);
        //db.execSQL("delete * from"+ TABLE_NAME);
//        db.execSQL("TRUNCATE table" + TABLE_NAME);
        db.execSQL("delete from "+ TABLE_NAME);
        db.close();

    }


}