package com.example.listviewexternalorsql;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.listviewexternalorsql.Model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListUsers extends AppCompatActivity {

    ListView listView;
    FloatingActionButton floatingActionButton;
    CustomAdapter adapter;
    ArrayList<User> arrayListUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        listView = findViewById(R.id.lists);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        String result = FileHelper.readData(getApplicationContext());
        List<User> users = User.toUser(result);
        arrayListUsers = new ArrayList<>(users);


        adapter = new CustomAdapter(arrayListUsers, this);
        listView.setAdapter(adapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListUsers.this, Register.class));
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        String result = FileHelper.readData(getApplicationContext());
        List<User> users = User.toUser(result);
        if(users.size() != 1)
            arrayListUsers.add(users.get(users.size()-1));
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}