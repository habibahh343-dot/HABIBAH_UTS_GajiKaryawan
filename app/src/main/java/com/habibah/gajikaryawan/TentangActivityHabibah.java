package com.habibah.gajikaryawan;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TentangActivityHabibah extends AppCompatActivity {

    Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_habibah);

        btnKembali = findViewById(R.id.btnKembali);
        btnKembali.setOnClickListener(v -> finish());
    }
}
