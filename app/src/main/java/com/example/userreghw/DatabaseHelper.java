package com.example.userreghw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Users.db";

    private static final String TABLE_NAME = "Users";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE " + TABLE_NAME + " (username TEXT PRIMARY KEY NOT NULL, firstname TEXT, lastname TEXT, email TEXT, password TEXT, age TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");

        onCreate(db);


    }

    public boolean initializeDB() {

        if(numberOfRowsInTable() == 0) {
            SQLiteDatabase db = this.getWritableDatabase();


            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES('Zmoore','Zackary','Moore','zmoore@gmail.com','Zmoore13','21');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES('S_Thomas','Shannon','Thomas','zmoore@gmail.com','Zmoore13','21');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES('BigG','Gabriel','Smith','zmoore@gmail.com','Zmoore13','21');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES('HMoore','Harrison','Moore','zmoore@gmail.com','Zmoore13','21');");

            db.close();

            return true;
        }

        else {
            return false;
        }
    }

    public int numberOfRowsInTable()
    {

        SQLiteDatabase db = this.getReadableDatabase();

        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);

        db.close();

        return numRows;
    }


    @SuppressLint("Range")
    public ArrayList<User> getAllRows()
    {
        ArrayList<User> listUsers = new ArrayList<User>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String fname;
        String lName;
        String username;
        String email;
        String password;
        String age;


        if(cursor.moveToFirst())
        {
            do
            {

                fname = cursor.getString(cursor.getColumnIndex("firstname"));

                lName = cursor.getString(cursor.getColumnIndex("lastname"));

                username = cursor.getString(cursor.getColumnIndex("username"));

                email = cursor.getString(cursor.getColumnIndex("email"));

                password = cursor.getString(cursor.getColumnIndex("password"));

                age = cursor.getString(cursor.getColumnIndex("age"));


                listUsers.add(new User(fname, lName, username, email, password, age));

            }
            while(cursor.moveToNext());
        }


        db.close();

        return listUsers;

    }


    public void addNewUser(User u)
    {
        SQLiteDatabase db = this.getWritableDatabase();


        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES ('" + u.getUsername() + "','" + u.getfName() + "','" + u.getlName() + "','" + u.getEmail() + "','" + u.getPassword() + "','" + u.getAge() + "');");


    }

    @SuppressLint("Range")
    public ArrayList<String> getAllUsernames()
    {
        ArrayList<String> usernames = new ArrayList<String>();


        String selectUserNames = "SELECT username FROM " + TABLE_NAME + " ORDER BY username;";


        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.rawQuery(selectUserNames, null);

        String username;

        if(cursor.moveToFirst())
        {
            do
            {
                username = cursor.getString(cursor.getColumnIndex("username"));

                usernames.add(username);
            }
            while(cursor.moveToNext());
        }
        db.close();

        return usernames;
    }
    public void deleteUser(String uName)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE username = '" + uName + "';");

        db.close();
    }

    public void updateUser(User u)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String updateCommand = "UPDATE " + TABLE_NAME + " SET firstname = '" + u.getfName() + "' , lastname = '" + u.getlName() + "' , email = '" + u.getEmail() + "' , password = '" + u.getPassword() + "' , age = '" + u.getAge() + "' WHERE username = '" + u.getUsername() +"';";
        db.execSQL(updateCommand);
        db.close();
    }



}
