package com.example.userreghw;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserListAdapter extends BaseAdapter
{

    Context context;
    ArrayList<User> userList;


    public UserListAdapter(Context c, ArrayList<User> ls)
    {
        context = c;
        userList = ls;

    }
    @Override
    public int getCount()
    {
        return userList.size();
    }

    @Override
    public Object getItem(int i)
    {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater mInflator = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            view = mInflator.inflate(R.layout.custom_cell, null);
        }
        TextView username = view.findViewById(R.id.tv_v_cus_username);
        TextView email = view.findViewById(R.id.tv_v_cus_email);

        User user = userList.get(i);

        username.setText(user.getUsername());
        email.setText(user.getEmail());


        return view;
    }
}
