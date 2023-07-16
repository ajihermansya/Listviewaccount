package com.example.listviewexternalorsql;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.example.listviewexternalorsql.Model.User;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHelper {
    /**
     * File Helper Bertujuan untuk
     * 1. Memastikan bahwa bisa melakukan akses ke external storage
     * 2. Menambah atau menulis data pada file di external storage
     * 3. Membaca data pada file di external storage.
     */
    private static final String TAG = "PERMISSION_TAG";
    private static String filename = "SampleFile.txt";
    private static String filepath = "MyFileStorage";
    static File myExternalFile;

    public static boolean preparation(Context con){
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
//            daftar.setEnabled(false);
            Log.d(TAG, "NOT READY YET");
            return false;
        }
        else {
            myExternalFile = new File(con.getExternalFilesDir(filepath), filename);
            return true;
        }
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    public static boolean writeData(Context con, String values){
        try {
            myExternalFile = new File(con.getExternalFilesDir(filepath), filename);
            FileOutputStream fos = new FileOutputStream(myExternalFile, true);
            fos.write(values.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String readData(Context con) {
        String myData = "";
        try {
            myExternalFile = new File(con.getExternalFilesDir(filepath), filename);
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            myData = e.getMessage();
        }
        return myData;
    }

//    public static void preparation(Context applicationContext) {
//    }
}
