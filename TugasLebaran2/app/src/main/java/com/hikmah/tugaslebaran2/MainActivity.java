package com.hikmah.tugaslebaran2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ediSisi;
    Button btnHitung;
    TextView tvHasil;
    Spinner spinnerPilih;
    String[] pilihHitung = {"Volume", "Keliling", "Luas Permukaan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ediSisi = findViewById(R.id.ed_sisi);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);
        spinnerPilih = findViewById(R.id.spinner_pilih);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinnerPilih.getSelectedItem().toString().equals(pilihHitung[0])) {
                    // rumus volum
                    //jenis methode 1 -> ctr+alt+m
                    rumusVolume();
                }else if(spinnerPilih.getSelectedItem().toString().equals(pilihHitung[1])) {
                    // rumus keliling
                    //jenis methode 2
                    Double sisi = Double.valueOf(ediSisi.getText().toString());
                    rumusKeliling(sisi);
                }else if(spinnerPilih.getSelectedItem().toString().equals(pilihHitung[2])) {
                    // rumus Luas permukaan
                    //jenis methode 3
                    Double sisi = Double.valueOf(ediSisi.getText().toString());
                    Double hasil = rumusLuasPermukaan();
                    tvHasil.setText(hasil.toString());
                }
            }
        });

        //data, adapter
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, pilihHitung);
        spinnerPilih.setAdapter(adapter);

    }

    private Double rumusLuasPermukaan() {
        Double sisi = Double.valueOf(ediSisi.getText().toString());
        Double hasil = 12 * sisi;
        return hasil;
    }

    private void rumusKeliling(Double sisi) {
        Double hasil = 6 * sisi * sisi;
        tvHasil.setText(hasil.toString());
    }

    private void rumusVolume() {
        Double sisi = Double.valueOf(ediSisi.getText().toString());
        Double hasil = sisi * sisi * sisi;
        tvHasil.setText(hasil.toString());
    }
}
