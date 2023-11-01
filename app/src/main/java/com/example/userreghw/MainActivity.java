package com.example.userreghw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button btn_j_main_addUser;
    ListView lv_j_main_users;
    Intent int_j_newUsersIntent;
    UserListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//finding the stuff
        btn_j_main_addUser = findViewById(R.id.btn_v_main_addUser);

        lv_j_main_users = findViewById(R.id.lv_v_main_users);

        //for changing intent to other one
        int_j_newUsersIntent = new Intent(MainActivity.this, NewUsers.class);

        addUserButtonEventHandler();

    }
    public void addUserButtonEventHandler()
    {
        btn_j_main_addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("yes", "yippie"); I was just testing like u do in class
                startActivity(int_j_newUsersIntent);


            }
        });
    }
    public void fillListView()
    {
        //adapter = new UserListAdapter(this, userList);

        lv_j_main_users.setAdapter(adapter);
    }

}