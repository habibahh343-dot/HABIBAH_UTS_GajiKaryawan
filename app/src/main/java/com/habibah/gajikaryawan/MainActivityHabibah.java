package com.habibah.gajikaryawan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityHabibah extends AppCompatActivity {

    LinearLayout btnGaji, btnPetunjuk, btnTentang, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_habibah);

        btnGaji = findViewById(R.id.btnGaji);
        btnPetunjuk = findViewById(R.id.btnPetunjuk);
        btnTentang = findViewById(R.id.btnTentang);
        btnExit = findViewById(R.id.btnExit);

        btnGaji.setOnClickListener(v ->
                startActivity(new Intent(MainActivityHabibah.this, GajiActivityHabibah.class)));

        btnPetunjuk.setOnClickListener(v ->
                startActivity(new Intent(MainActivityHabibah.this, PetunjukActivityHabibah.class)));

        btnTentang.setOnClickListener(v ->
                startActivity(new Intent(MainActivityHabibah.this, TentangActivityHabibah.class)));

        btnExit.setOnClickListener(v -> finishAffinity());
    }
}
