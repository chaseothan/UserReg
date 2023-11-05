package com.example.userreghw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_j_main_addUser;
    ListView lv_j_main_users;
    Intent int_j_newUsersIntent;
    UserListAdapter adapter;
    DatabaseHelper dbHelper;
    ArrayList<User> userList;
    ArrayList<String> usernames;
    Intent updateIntent;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//finding the stuff



        userList = new ArrayList<User>();


        btn_j_main_addUser = findViewById(R.id.btn_v_main_addUser);

        lv_j_main_users = findViewById(R.id.lv_v_main_users);

        //Log.d("HERE", "HERE");

        //for changing intent to other one
        int_j_newUsersIntent = new Intent(MainActivity.this, NewUsers.class);
        updateIntent = new Intent(MainActivity.this, UserInfo.class);

        //database stuff
        addUserButtonEventHandler();
        dbHelper = new DatabaseHelper(this);
        dbHelper.initializeDB();

        userList = dbHelper.getAllRows();

        for (int i = 0; i < userList.size(); i++)
        {
            Log.d("NAME", userList.get(i).getfName() + "");
        }

        adapter = new UserListAdapter(this, userList);

        lv_j_main_users.setAdapter(adapter);


        //Log.d("number of records", dbHelper.numberOfRowsInTable() + "");

        usernames = dbHelper.getAllUsernames();


        fillListView();
        listViewEvent();
        updateUser();

    }
    public void addUserButtonEventHandler()
    {
        btn_j_main_addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("yes","ippie"); I was just testing like u do in class
                startActivity(int_j_newUsersIntent);
            }
        });
    }
    public void fillListView()
    {
        lv_j_main_users.setAdapter(adapter);
    }

    public void listViewEvent()
    {

        lv_j_main_users.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                dbHelper.deleteUser(usernames.get(i));

                userList.remove(i);

                usernames.remove(i);

                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    public void updateUser()
    {
        lv_j_main_users.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                updateIntent.putExtra("User", userList.get(i));
                startActivity(updateIntent);

            }
        });
    }


}

