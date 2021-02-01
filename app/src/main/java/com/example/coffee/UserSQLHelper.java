package com.example.coffee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UserSQLHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "User";
    static final String DB_TABLE_USER = "UserList";
    static final int DB_VERSION = 1;
    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;
    Cursor cursor;

    public UserSQLHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE UserList(" +
                "id INTEGER NOT NULL PRIMARY KEY," +
                "name TEXT," +
                "pass TEXT," +
                "phone TEXT," +
                "image TEXT," +
                "role INTEGER)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i!=i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DB_NAME);
            onCreate(sqLiteDatabase);
        }
    }

    public int countTable(){
        sqLiteDatabase=getWritableDatabase();
        cursor=sqLiteDatabase.rawQuery("Select * from "+DB_TABLE_USER, null);
        return cursor.getCount();
    }

    public boolean checkName(String name){
        sqLiteDatabase=getWritableDatabase();
        cursor=sqLiteDatabase.rawQuery("Select * from "+DB_TABLE_USER+" where name='"+name+"'", null);
        if(cursor.getCount()!=0)
            return true;
        return false;
    }

    public int getRoleUser(String name, String pass){
        List<User> list=new ArrayList<>();

        User user;

        sqLiteDatabase=getWritableDatabase();
        cursor=sqLiteDatabase.rawQuery("Select * from "+DB_TABLE_USER+" where name='"+name.trim()
                +"' and pass='"+pass.trim()+"'", null);
        while(cursor.moveToNext()){
            int id=cursor.getInt(cursor.getColumnIndex("id"));
            String name1=cursor.getString(cursor.getColumnIndex("name"));
            String pass1=cursor.getString(cursor.getColumnIndex("pass"));
            String phone=cursor.getString(cursor.getColumnIndex("phone"));
            String image=cursor.getString(cursor.getColumnIndex("image"));
            int role=cursor.getInt(cursor.getColumnIndex("role"));
            user=new User(id, name, pass, phone, image, role);
            list.add(user);
        }
        return list.get(0).getRole();
    }

    public boolean checkAccount(String name, String pass){
        sqLiteDatabase=getWritableDatabase();
        cursor=sqLiteDatabase.rawQuery("Select * from "+DB_TABLE_USER+" where name='"+name.trim()
                +"' and pass='"+pass.trim()+"'", null);
        if (cursor.getCount()==1)
            return true;
        return false;
    }

    public void insert(User user){
        sqLiteDatabase=getWritableDatabase();
        contentValues=new ContentValues();

        contentValues.put("id", user.getId());
        contentValues.put("name", user.getName());
        contentValues.put("pass", user.getPass());
        contentValues.put("phone", user.getPhone());
        contentValues.put("image", user.getImage());
        contentValues.put("role", user.getRole());

        sqLiteDatabase.insert(DB_TABLE_USER, null, contentValues);
    }

    public void delete(User user){

    }

    public void update(User user){
        sqLiteDatabase=getWritableDatabase();
        contentValues=new ContentValues();

        contentValues.put("name", user.getName());
        contentValues.put("pass", user.getPass());
        contentValues.put("phone", user.getPhone());
        contentValues.put("image", user.getImage());
        contentValues.put("role", user.getRole());

        sqLiteDatabase.update(DB_TABLE_USER, contentValues, "id=?",
                new String[]{String.valueOf(user.getId())});
    }
}
