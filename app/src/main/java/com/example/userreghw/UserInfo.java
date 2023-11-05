package com.example.userreghw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserInfo extends AppCompatActivity {

    Button btn_j_userInfo_update;
    EditText et_j_userInfo_firstname;
    EditText et_j_userInfo_lastname;
    EditText et_j_userInfo_email;
    EditText et_j_userInfo_password;
    EditText et_j_userInfo_age;
    User userPassed;
    Intent mainActivity;
    DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        btn_j_userInfo_update = findViewById(R.id.btn_v_userInfo_update);
        et_j_userInfo_firstname = findViewById(R.id.et_v_userInfo_firstName);
        et_j_userInfo_lastname = findViewById(R.id.et_v_userInfo_lastName);
        et_j_userInfo_email = findViewById(R.id.et_v_userInfo_email);
        et_j_userInfo_password = findViewById(R.id.et_v_userInfo_password);
        et_j_userInfo_age = findViewById(R.id.et_v_userInfo_age);

        mainActivity = new Intent(UserInfo.this, MainActivity.class);

        Intent cameFrom = getIntent();

        userPassed = (User) cameFrom.getSerializableExtra("User");

        dbHelper = new DatabaseHelper(this);

        et_j_userInfo_firstname.setText(userPassed.getfName());
        et_j_userInfo_lastname.setText(userPassed.getlName());
        et_j_userInfo_email.setText(userPassed.getEmail());
        et_j_userInfo_password.setText(userPassed.getPassword());
        et_j_userInfo_age.setText(userPassed.getAge());
//this breaks


        updateUserEvent();



    }
    public void updateUserEvent()
    {
        btn_j_userInfo_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userPassed.setfName(et_j_userInfo_firstname.getText().toString());
                userPassed.setlName(et_j_userInfo_lastname.getText().toString());
                userPassed.setEmail(et_j_userInfo_email.getText().toString());
                userPassed.setPassword(et_j_userInfo_password.getText().toString());
                userPassed.setAge(et_j_userInfo_age.getText().toString());

                dbHelper.updateUser(userPassed);

                startActivity(mainActivity);
            }
        });
    }



}