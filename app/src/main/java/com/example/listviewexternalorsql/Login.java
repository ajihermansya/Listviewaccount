package com.example.listviewexternalorsql;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listviewexternalorsql.Model.User;

import java.io.File;
import java.util.List;

public class Login extends AppCompatActivity {

    Button login, register;
    EditText eUsername, ePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        eUsername = findViewById(R.id.editUsernameLogin);
        ePassword = findViewById(R.id.editPasswordLogin);

        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mengecek file txt yang berisi username dan password
                String username = eUsername.getText().toString();
                String password = ePassword.getText().toString();

                String result = FileHelper.readData(getApplicationContext());
                List<User> users = User.toUser(result);
                if(User.loginCheck(username,password, users)){
                    startActivity(new Intent(Login.this, ListUsers.class));
                    Toast.makeText(getBaseContext(), "Login Sukses", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(), "Username dan Password Salah atau Tidak Ditemukan", Toast.LENGTH_SHORT).show();
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

        if(FileHelper.preparation(getApplicationContext())){
            Toast.makeText(getBaseContext(), "External Storage Ready", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getBaseContext(), "External Storage NOT READY", Toast.LENGTH_SHORT).show();
        }
    }
}