package com.example.e_perjadin;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PerjalananActivity extends AppCompatActivity {

    private EditText noSuratTugasEditText;
    private EditText NamaEditText;
    private EditText nipEditText;
    private EditText tempatPerjadinEditText;
    private EditText tanggalBerangkatEditText;
    private EditText tanggalSelesaiEditText;
    private EditText lamaDinasEditText;
    private EditText kegiatanPerjadinEditText;
    private Button resetButton;
    private Button submitButton;
    private Button keluarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perjalanan);

        // Inisialisasi EditText
        noSuratTugasEditText = findViewById(R.id.noSuratTugasEditText);
        NamaEditText = findViewById(R.id.NamaEditText);
        nipEditText = findViewById(R.id.nipEditText);
        tempatPerjadinEditText = findViewById(R.id.tempatPerjadinEditText);
        tanggalBerangkatEditText = findViewById(R.id.tanggalBerangkatEditText);
        tanggalSelesaiEditText = findViewById(R.id.tanggalSelesaiEditText);
        lamaDinasEditText = findViewById(R.id.lamaDinasEditText);
        kegiatanPerjadinEditText = findViewById(R.id.kegiatanPerjadinEditText);

        // Inisialisasi Button
        resetButton = findViewById(R.id.resetButton);
        submitButton = findViewById(R.id.submitButton);
        keluarButton = findViewById(R.id.keluarButton);

        // Mengatur aksi klik untuk tombol reset
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menghapus isi semua EditText
                noSuratTugasEditText.setText("");
                NamaEditText.setText("");
                nipEditText.setText("");
                tempatPerjadinEditText.setText("");
                tanggalBerangkatEditText.setText("");
                tanggalSelesaiEditText.setText("");
                lamaDinasEditText.setText("");
                kegiatanPerjadinEditText.setText("");
            }
        });

        // Mengatur aksi klik untuk tombol submit
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mendapatkan nilai dari setiap EditText
                String noSuratTugas = noSuratTugasEditText.getText().toString();
                String nama = NamaEditText.getText().toString();
                String nip = nipEditText.getText().toString();
                String tempatPerjadin = tempatPerjadinEditText.getText().toString();
                String tanggalBerangkat = tanggalBerangkatEditText.getText().toString();
                String tanggalSelesai = tanggalSelesaiEditText.getText().toString();
                String lamaDinas = lamaDinasEditText.getText().toString();
                String kegiatanPerjadin = kegiatanPerjadinEditText.getText().toString();

                // Lakukan tindakan yang sesuai dengan data yang dikumpulkan
                // Misalnya, menyimpan data ke database atau menampilkan pesan sukses

                // Contoh aksi: menampilkan data yang diinputkan
                String dataPerjalanan = "No. Surat Tugas: " + noSuratTugas +
                        "\nNama: " + nama +
                        "\nNIP: " + nip +
                        "\nTempat Perjadin: " + tempatPerjadin +
                        "\nTanggal Berangkat: " + tanggalBerangkat +
                        "\nTanggal Selesai: " + tanggalSelesai +
                        "\nLama Dinas: " + lamaDinas +
                        "\nKegiatan Perjadin: " + kegiatanPerjadin;

                // Tampilkan data di logcat
                Log.d("Data Perjalanan", dataPerjalanan);
            }
        });

        // Mengatur aksi klik untuk tombol keluar
        keluarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Menutup aktivitas
            }
        });
    }
}
