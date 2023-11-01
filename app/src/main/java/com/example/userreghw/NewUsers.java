package com.example.userreghw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class NewUsers extends AppCompatActivity {

    Intent int_j_mainActivityIntent;
    Button btn_j_users_back;
    Button btn_j_users_add;
    EditText et_j_users_fName;
    EditText et_j_users_lName;
    EditText et_j_users_username;
    EditText et_j_users_email;
    EditText et_j_users_password;
    EditText et_j_users_age;
    ArrayList<User> userList;
    DatabaseHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_users);


        et_j_users_fName = findViewById(R.id.et_v_users_fName);
        et_j_users_lName = findViewById(R.id.et_v_users_lName);
        et_j_users_username = findViewById(R.id.et_v_users_username);
        et_j_users_email = findViewById(R.id.et_v_users_email);
        et_j_users_password = findViewById(R.id.et_v_users_password);
        et_j_users_age = findViewById(R.id.et_v_users_age);


        btn_j_users_add = findViewById(R.id.btn_v_users_addUser);
        btn_j_users_back = findViewById(R.id.btn_v_users_back);
        int_j_mainActivityIntent = new Intent(NewUsers.this, MainActivity.class);

        userList = new ArrayList<User>();

        dbHelper = new DatabaseHelper(this);

        dbHelper.initializeDB();

        userList = dbHelper.getAllRows();

        displayUsers();


        backButtonEventHandler();
        addButtonEventHandler();



    }
    public void backButtonEventHandler()
    {
        btn_j_users_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(int_j_mainActivityIntent);
            }
        });


    }
    public void addButtonEventHandler()
    {
        btn_j_users_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f = et_j_users_fName.getText().toString();
                String l = et_j_users_lName.getText().toString();
                String u = et_j_users_username.getText().toString();
                String e = et_j_users_email.getText().toString();
                String p = et_j_users_password.getText().toString();
                String a = et_j_users_age.getText().toString();

                User newUser = new User(u, f, l, e, p, a);

                addNewUser(newUser);

                displayUsers();

                et_j_users_fName.setText("");
                et_j_users_lName.setText("");
                et_j_users_username.setText("");
                et_j_users_email.setText("");
                et_j_users_password.setText("");
                et_j_users_age.setText("");


                //adapter.notifyDataSetChange();
            }
        });
    }

    public void addNewUser(User u)
    {

        if(!et_j_users_fName.getText().toString().equals("") && !et_j_users_lName.getText().toString().equals("") && !et_j_users_username.getText().toString().equals("") && !et_j_users_email.getText().toString().equals("") && !et_j_users_password.getText().toString().equals("") && !et_j_users_age.getText().toString().equals(""))
        {
            userList.add(u);
            dbHelper.addNewUser(u);

        }
    }

    public void displayUsers()
    {
        for (int i = 0; i < userList.size(); i++)
        {

        }

    }

}