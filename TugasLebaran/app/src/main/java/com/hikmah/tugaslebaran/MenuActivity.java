package com.hikmah.tugaslebaran;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    //1. membuat var
    Button btnLinear;
    Button btnRelative, btnFrame, btnConstrain, btnScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //2. inisialisasi var by id
        btnLinear = findViewById(R.id.btn_linear);
        btnRelative = findViewById(R.id.btn_relative);
        btnFrame = findViewById(R.id.btn_frame);
        btnConstrain = findViewById(R.id.btn_constrain);
        btnScroll = findViewById(R.id.btn_scroll);

        //3. membuat handling/ set klik listener
        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MenuActivity.this, "Ini POPUP, Toast", Toast.LENGTH_SHORT).show();
                Intent pindah = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(pindah);
            }
        });

        btnRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //nama_komponen var = new nama_komponen(nama_dari_activity.this)
                AlertDialog.Builder pesan = new AlertDialog.Builder(MenuActivity.this);
                pesan.setTitle("Alert Dialog");
                pesan.setMessage("Ini POPUP, Alert Dialog");
                pesan.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActivity.this, "Anda memilih ok", Toast.LENGTH_SHORT).show();
                        Intent pindah = new Intent(MenuActivity.this, RelativeActivity.class);
                        startActivity(pindah);
                    }
                });
                pesan.setNegativeButton("Cancel", null);
                pesan.show();
            }
        });

        btnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(MenuActivity.this, FrameActivity.class);
                startActivity(pindah);
            }
        });

        btnConstrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(MenuActivity.this, ConstrainActivity.class);
                startActivity(pindah);
            }
        });

        btnScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(MenuActivity.this, ScrollActivity.class);
                startActivity(pindah);
            }
        });
    }
}
