package com.example.e_perjadin;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class LaporanActivity extends AppCompatActivity {
    private ListView listView;
    private List<Perjalanan> perjalananList;
    private PerjalananAdapter adapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);

        listView = findViewById(R.id.listView);

        databaseHelper = new DatabaseHelper(this);

        perjalananList = new ArrayList<>();
        adapter = new PerjalananAdapter(this, perjalananList);

        listView.setAdapter(adapter);

        loadDataPerjalanan();
    }

    private void loadDataPerjalanan() {
        perjalananList.clear();

        Cursor cursor = databaseHelper.getAllPerjalanan();

        int idColumnIndex = cursor.getColumnIndex("_id");
        int noSuratTugasColumnIndex = cursor.getColumnIndex("no_surat_tugas");
        int namaColumnIndex = cursor.getColumnIndex("nama");
        int nipColumnIndex = cursor.getColumnIndex("nip");
        int tempatPerjadinColumnIndex = cursor.getColumnIndex("tempat_perjadin");
        int tanggalBerangkatColumnIndex = cursor.getColumnIndex("tanggal_berangkat");
        int tanggalSelesaiColumnIndex = cursor.getColumnIndex("tanggal_selesai");
        int lamaDinasColumnIndex = cursor.getColumnIndex("lama_dinas");
        int kegiatanPerjadinColumnIndex = cursor.getColumnIndex("kegiatan_perjadin");

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(idColumnIndex);
                String noSuratTugas = noSuratTugasColumnIndex != -1 ? cursor.getString(noSuratTugasColumnIndex) : "";
                String nama = namaColumnIndex != -1 ? cursor.getString(namaColumnIndex) : "";
                String nip = nipColumnIndex != -1 ? cursor.getString(nipColumnIndex) : "";
                String tempatPerjadin = tempatPerjadinColumnIndex != -1 ? cursor.getString(tempatPerjadinColumnIndex) : "";
                String tanggalBerangkat = tanggalBerangkatColumnIndex != -1 ? cursor.getString(tanggalBerangkatColumnIndex) : "";
                String tanggalSelesai = tanggalSelesaiColumnIndex != -1 ? cursor.getString(tanggalSelesaiColumnIndex) : "";
                String lamaDinas = lamaDinasColumnIndex != -1 ? cursor.getString(lamaDinasColumnIndex) : "";
                String kegiatanPerjadin = kegiatanPerjadinColumnIndex != -1 ? cursor.getString(kegiatanPerjadinColumnIndex) : "";

                Perjalanan perjalanan = new Perjalanan(id, noSuratTugas, nama, nip, tempatPerjadin, tanggalBerangkat, tanggalSelesai, lamaDinas, kegiatanPerjadin);
                perjalananList.add(perjalanan);
            } while (cursor.moveToNext());
        }

        cursor.close();

        adapter.notifyDataSetChanged();
    }

}
