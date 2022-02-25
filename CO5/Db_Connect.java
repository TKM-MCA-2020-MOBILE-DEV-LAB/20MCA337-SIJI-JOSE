package com.example.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Db_Connect extends SQLiteOpenHelper{
    public static final String CUST_DETAILS = "cust_details";

    public Db_Connect(@Nullable Context context) {
        super(context,"customer.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String table= "CREATE TABLE " + CUST_DETAILS + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,CUSTOMER_NAME TEXT,AGE INTEGER ,ACTIVE_STATUS BOOL)";
        sqLiteDatabase.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addone(Customer customer){
        SQLiteDatabase sqlDatabase= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("CUSTOMER_NAME",customer.getName());
        values.put("AGE",customer.getName());
        values.put("ACTIVE_STATUS",customer.getName());
        long insert=sqlDatabase.insert(CUST_DETAILS,null,values);
        if(insert==-1){
            return false;
        }
        else{
            return true;
        }
    }
}
