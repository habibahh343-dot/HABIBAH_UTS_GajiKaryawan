package com.habibah.gajikaryawan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class GajiActivityHabibah extends AppCompatActivity {

    EditText edtNik, edtNama, edtGajiPokok, edtTunjJabatan, edtHariKerja;
    TextView txtTunjMakan, txtTunjTransport, txtGajiKotor, txtGajiBersih;
    Button btnHitung, btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji_habibah);

        edtNik = findViewById(R.id.edtNik);
        edtNama = findViewById(R.id.edtNama);
        edtGajiPokok = findViewById(R.id.edtGajiPokok);
        edtTunjJabatan = findViewById(R.id.edtTunjJabatan);
        edtHariKerja = findViewById(R.id.edtHariKerja);

        txtTunjMakan = findViewById(R.id.txtTunjMakan);
        txtTunjTransport = findViewById(R.id.txtTunjTransport);
        txtGajiKotor = findViewById(R.id.txtGajiKotor);
        txtGajiBersih = findViewById(R.id.txtGajiBersih);

        btnHitung = findViewById(R.id.btnHitung);
        btnKembali = findViewById(R.id.btnKembali);

        btnHitung.setOnClickListener(v -> hitungGaji());
        btnKembali.setOnClickListener(v -> finish());
    }

    private void hitungGaji() {
        String nik = edtNik.getText().toString().trim();
        String nama = edtNama.getText().toString().trim();
        String sGajiPokok = edtGajiPokok.getText().toString().trim();
        String sTunjJabatan = edtTunjJabatan.getText().toString().trim();
        String sHariKerja = edtHariKerja.getText().toString().trim();

        if (nik.isEmpty() || nama.isEmpty() || sGajiPokok.isEmpty()
                || sTunjJabatan.isEmpty() || sHariKerja.isEmpty()) {
            Toast.makeText(this, R.string.data_kosong, Toast.LENGTH_SHORT).show();
            return;
        }

        double gajiPokok = Double.parseDouble(sGajiPokok);
        double tunjJabatan = Double.parseDouble(sTunjJabatan);
        int hariKerja = Integer.parseInt(sHariKerja);

        // Proses
        double tunjMakan = hariKerja * 10000;
        double tunjTransport = hariKerja * 5000;
        double gajiKotor = gajiPokok + tunjJabatan + tunjMakan + tunjTransport;
        double pajak = 0.10 * gajiKotor;
        double gajiBersih = gajiKotor - pajak;

        // Output
        txtTunjMakan.setText(rupiah(tunjMakan));
        txtTunjTransport.setText(rupiah(tunjTransport));
        txtGajiKotor.setText(rupiah(gajiKotor));
        txtGajiBersih.setText(rupiah(gajiBersih));
    }

    private String rupiah(double angka) {
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
        nf.setMaximumFractionDigits(0);
        return "Rp " + nf.format(angka);
    }
}
