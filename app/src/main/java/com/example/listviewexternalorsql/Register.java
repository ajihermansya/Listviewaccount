package com.example.listviewexternalorsql;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;

import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.listviewexternalorsql.Model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Register extends AppCompatActivity {
    private static final int STORAGE_PERMISSION_CODE = 100;


    EditText eUsername, ePass, eEmail;
    Button daftar;
    String val_username, val_pass, val_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        eUsername = (EditText) findViewById(R.id.editUsername);
        ePass = (EditText) findViewById(R.id.editPassword);
        eEmail = (EditText) findViewById(R.id.editEmail);
        daftar = findViewById(R.id.btnDaftar);




        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val_username = eUsername.getText().toString();
                val_pass = ePass.getText().toString();
                val_email = eEmail.getText().toString();
                User newUser = new User(val_username, val_pass, val_email);
                if(FileHelper.writeData(getApplicationContext(), newUser.toString())){
                    Toast.makeText(getBaseContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                    finish(); //suatu fungsi yang ada di android untuk men-terminate halaman aktif
                }else{
                    Toast.makeText(getBaseContext(), "CHECK LOG", Toast.LENGTH_SHORT).show();
                }

            }
        });





    }



}