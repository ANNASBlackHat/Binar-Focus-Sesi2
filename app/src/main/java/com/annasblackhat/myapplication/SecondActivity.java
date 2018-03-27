package com.annasblackhat.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtData = findViewById(R.id.txt_data);

//        Mahasiswa mhs = (Mahasiswa) getIntent().getSerializableExtra("data");
        Mahasiswa2 data = getIntent().getParcelableExtra("data");
        txtData.setText(data.getName() + " - " + data.getAddress());
    }
}
