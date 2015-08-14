package com.akshay.simpledbapp;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Akshay on 7/9/2015.
 */
public class Database extends SQLiteOpenHelper {
    private static final int DB_VERSION = 9;
    private static final String DB_NAME = "deo3.db";
    private static final String TABLE_DEO = "Deotable123213";
Context c;

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.c = context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_DEO + "(column VARCHAR primary key) ;");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEO);
        onCreate(db);

    }
    public void database(String update)
    {

        if(!update.matches("")) {
            try {
                SQLiteDatabase db = this.getWritableDatabase();
                //ContentValues  values = new ContentValues();
                //values.put(DEO_TEXT,update);
                db.execSQL("INSERT OR REPLACE INTO " + TABLE_DEO + " (column) Values (\"" + update + "\");");
                //db.insert(TABLE_DEO,null,values);
                db.close();
            } catch (SQLiteException e) {

                e.printStackTrace();
            }
        }
    }
    public String data()
    {
        String out;
        String out_2="";
        try{
            SQLiteDatabase db = this.getReadableDatabase();
            db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_DEO+"(column VARCHAR primary key);");
            Cursor cursor;
            cursor = db.rawQuery("Select * FROM "+TABLE_DEO,null);
            if(cursor!=null)
            {
                if(cursor.moveToFirst())
                {
                    do
                    {
                        out=cursor.getString(0);
                        out_2= out_2+out+"\n";
                    }while(cursor.moveToNext());
                }
            }
            db.close();
        }catch (SQLiteException e)
        {

            e.printStackTrace();
            return "";
        }
        return out_2;
    }
}
