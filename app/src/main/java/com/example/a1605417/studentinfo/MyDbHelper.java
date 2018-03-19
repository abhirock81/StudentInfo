package com.example.a1605417.studentinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDbHelper extends SQLiteOpenHelper {

    String table_name = "details";
    static String col1 = "name";
    static String col2 = "email";
    static String col3 = "password";
    static String col4 = "contact";
    static String col5 = "gender";
    static String col6 = "dob";
    static String col7 = "city";

    String create_query = "create table " + table_name + "(" + col1 + " text," + col2 + " text primary key," + col3 + " text," + col4 + " text," + col5 + " text," + col6 + " text," + col7 + " text);";

    public MyDbHelper(Context context) {
        super(context, "mydb", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }

    public long insertData(String name, String email, String password, String contact, String gender, String dob, String city) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1, name);
        contentValues.put(col2, email);
        contentValues.put(col3, password);
        contentValues.put(col4, contact);
        contentValues.put(col5, gender);
        contentValues.put(col6, dob);
        contentValues.put(col7, city);

        long a = sqLiteDatabase.insert(table_name, null, contentValues);
        return a;
    }

    public Cursor login(String email, String password) {
        String[] clmns = {col1, col2, col3, col4, col5, col6, col7};
        String selection = col2 + "=? and " + col3 + "=?";
        String[] args = {email, password};
        Cursor cursor = getWritableDatabase().query(table_name, clmns, selection, args, null, null, null);
        return cursor;
    }


    public int delData(String email) {
        String wh_c = col2 + "=?";
        String[] arg = {email};
        int a = getWritableDatabase().delete(table_name, wh_c, arg);
        return a;
    }

    public int updateData(String email, String name, String email1, String password, String contact, String gender, String dob, String city) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1, name);
        contentValues.put(col2, email1);
        contentValues.put(col3, password);
        contentValues.put(col4, contact);
        contentValues.put(col5, gender);
        contentValues.put(col6, dob);
        contentValues.put(col7, city);

        String wh_c = col2 + "=?";
        String[] arg = {email};
        int a = getWritableDatabase().update(table_name, contentValues, wh_c, arg);
        return a;
    }
}
