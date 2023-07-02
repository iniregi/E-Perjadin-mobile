package com.example.e_perjadin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;

public class PerjalananActivity extends AppCompatActivity {
    private EditText noSuratTugasEditText;
    private EditText namaEditText;
    private EditText nipEditText;
    private EditText tempatPerjadinEditText;
    private EditText tanggalBerangkatEditText;
    private EditText tanggalSelesaiEditText;
    private EditText lamaDinasEditText;
    private EditText kegiatanPerjadinEditText;
    private Button resetButton;
    private Button submitButton;
    private Button keluarButton;

    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perjalanan);

        noSuratTugasEditText = findViewById(R.id.noSuratTugasEditText);
        namaEditText = findViewById(R.id.NamaEditText);
        nipEditText = findViewById(R.id.nipEditText);
        tempatPerjadinEditText = findViewById(R.id.tempatPerjadinEditText);
        tanggalBerangkatEditText = findViewById(R.id.tanggalBerangkatEditText);
        tanggalSelesaiEditText = findViewById(R.id.tanggalSelesaiEditText);
        lamaDinasEditText = findViewById(R.id.lamaDinasEditText);
        kegiatanPerjadinEditText = findViewById(R.id.kegiatanPerjadinEditText);
        resetButton = findViewById(R.id.resetButton);
        submitButton = findViewById(R.id.submitButton);
        keluarButton = findViewById(R.id.keluarButton);

        // Membuat objek DatabaseHelper
        DatabaseHelper dbHelper = new DatabaseHelper(this);

        // Mendapatkan instance dari SQLiteDatabase
        database = dbHelper.getWritableDatabase();

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        keluarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void resetFields() {
        noSuratTugasEditText.setText("");
        namaEditText.setText("");
        nipEditText.setText("");
        tempatPerjadinEditText.setText("");
        tanggalBerangkatEditText.setText("");
        tanggalSelesaiEditText.setText("");
        lamaDinasEditText.setText("");
        kegiatanPerjadinEditText.setText("");
    }

    private void saveData() {
        String noSuratTugas = noSuratTugasEditText.getText().toString();
        String nama = namaEditText.getText().toString();
        String nip = nipEditText.getText().toString();
        String tempatPerjadin = tempatPerjadinEditText.getText().toString();
        String tanggalBerangkat = tanggalBerangkatEditText.getText().toString();
        String tanggalSelesai = tanggalSelesaiEditText.getText().toString();
        String lamaDinas = lamaDinasEditText.getText().toString();
        String kegiatanPerjadin = kegiatanPerjadinEditText.getText().toString();

        // Memasukkan data ke dalam ContentValues
        ContentValues values = new ContentValues();
        values.put("no_surat_tugas", noSuratTugas);
        values.put("nama", nama);
        values.put("nip", nip);
        values.put("tempat_perjadin", tempatPerjadin);
        values.put("tanggal_berangkat", tanggalBerangkat);
        values.put("tanggal_selesai", tanggalSelesai);
        values.put("lama_dinas", lamaDinas);
        values.put("kegiatan_perjadin", kegiatanPerjadin);

        // Menyimpan data ke dalam tabel perjalanan
        long result = database.insert("perjalanan", null, values);

        if (result == -1) {
            Toast.makeText(this, "Failed to save data", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
            resetFields();

            // Start LaporanActivity
            Intent intent = new Intent(PerjalananActivity.this, LaporanActivity.class);
            startActivity(intent);
        }
    }


    // DatabaseHelper untuk membuat dan mengelola database
    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "perjalanan.db";
        private static final int DATABASE_VERSION = 1;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // Membuat tabel perjalanan
            db.execSQL("CREATE TABLE perjalanan (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "no_surat_tugas TEXT," +
                    "nama TEXT," +
                    "nip TEXT," +
                    "tempat_perjadin TEXT," +
                    "tanggal_berangkat TEXT," +
                    "tanggal_selesai TEXT," +
                    "lama_dinas TEXT," +
                    "kegiatan_perjadin TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Menghapus tabel perjalanan jika ada versi sebelumnya
            db.execSQL("DROP TABLE IF EXISTS perjalanan");
            onCreate(db);
        }
    }
}
