package com.annasblackhat.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "oncreate...", Toast.LENGTH_SHORT).show();

        txtData = findViewById(R.id.txt_data);

        findViewById(R.id.btn_load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });

        findViewById(R.id.btn_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setName("Andrias");
                mhs.setAge(18);
                mhs.setAddress("Kota Baru");

                Mahasiswa2 mhs2 = new Mahasiswa2();
                mhs2.setName("Slamet");
                mhs2.setAddress("Kalimantan");

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                intent.putExtra("data", txtData.getText().toString());
                intent.putExtra("data", mhs2);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Hey,, this is from my app");
                intent.setType("text/plain");
                intent.setPackage("jp.naver.line.android");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "You have no Line installed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btn_take_picture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_write_log).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLog();
            }
        });
    }

    private void writeLog() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 123);
            return;
        }

        Util.appendLog("first log....");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 123){
            writeLog();
        }
    }

    private void loadData() {
        String data = "nama: Wahyu, Umur: 18, Asal: Bandung";
        txtData.setText(data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data", txtData.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String data = savedInstanceState.getString("data");
        txtData.setText(data);
    }
}
