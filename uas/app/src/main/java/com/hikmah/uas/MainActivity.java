package com.hikmah.uas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNama;
    private EditText editTextNohp;
    private EditText editTextAlamat;

    private Button buttonAdd;
    private Button buttonView;
    private Spinner spinJk;

    String[] JK = {"Laki Laki", "Perempuan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNama = (EditText)findViewById(R.id.ed_nama);
        editTextNohp = (EditText)findViewById(R.id.ed_nohp);
        editTextAlamat = (EditText)findViewById(R.id.ed_alamat);
        spinJk = findViewById(R.id.spinner_pilih);

        buttonAdd = (Button)findViewById(R.id.btn_tmbh);
        buttonView = (Button)findViewById(R.id.btn_simpan);


        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, JK);
        spinJk.setAdapter(adapter);
    }

    private void addEmployee(){
        final String nama = editTextNama.getText().toString().trim();
        final String nohp = editTextNohp.getText().toString().trim();
        final String alamat = editTextAlamat.getText().toString().trim();
        final String spin = spinJk.getSelectedItem().toString().trim();

        class AddEmployee extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this, "Menambahkan...",
                        "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_EMP_NAMA, nama);
                params.put(Konfigurasi.KEY_EMP_NOHP, nohp);
                params.put(Konfigurasi.KEY_EMP_ALAMAT, alamat);
                params.put(Konfigurasi.KEY_EMP_JENISKELAMIN, spin);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Konfigurasi.URL_ADD, params);
                return res;
            }
        }
        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    private void addEmployee1(){
        final String nama = editTextNama.getText().toString().trim();
        final String nohp = editTextNohp.getText().toString().trim();
        final String alamat = editTextAlamat.getText().toString().trim();
        final String spin = spinJk.getSelectedItem().toString().trim();

        class AddEmployee extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this, "Menambahkan...",
                        "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_EMP_NAMA, nama);
                params.put(Konfigurasi.KEY_EMP_NOHP, nohp);
                params.put(Konfigurasi.KEY_EMP_ALAMAT, alamat);
                params.put(Konfigurasi.KEY_EMP_JENISKELAMIN, spin);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Konfigurasi.URL_ADD, params);
                return res;
            }
        }
        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    public void onClick(View view) {
        if (view == buttonAdd){
            if (spinJk.getSelectedItem().toString().equals(JK[0])){
                addEmployee();
            }else if (spinJk.getSelectedItem().toString().equals(JK[1])){
                addEmployee1();
            }
        }
        if (view == buttonView){
            Intent a = new Intent(MainActivity.this, TampilActivity.class);
            startActivity(a);
        }
    }
}
