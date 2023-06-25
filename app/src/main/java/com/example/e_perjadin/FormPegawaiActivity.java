package com.example.e_perjadin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormPegawaiActivity extends AppCompatActivity {

    private EditText nipEditText, namaEditText, tanggalLahirEditText, jabatanEditText, golonganEditText, alamatEditText;
    private Button simpanButton, keluarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pegawai);


        nipEditText = findViewById(R.id.nip_edittext);
        namaEditText = findViewById(R.id.nama_edittext);
        tanggalLahirEditText = findViewById(R.id.tanggal_lahir_edittext);
        jabatanEditText = findViewById(R.id.jabatan_edittext);
        golonganEditText = findViewById(R.id.golongan_edittext);
        alamatEditText = findViewById(R.id.alamat_edittext);
        simpanButton = findViewById(R.id.simpan_button);
        keluarButton = findViewById(R.id.keluar_button);

        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nip = nipEditText.getText().toString().trim();
                String nama = namaEditText.getText().toString().trim();
                String tanggalLahir = tanggalLahirEditText.getText().toString().trim();
                String jabatan = jabatanEditText.getText().toString().trim();
                String golongan = golonganEditText.getText().toString().trim();
                String alamat = alamatEditText.getText().toString().trim();


                String message = "NIP: " + nip + "\nNama Pegawai: " + nama +
                        "\nTanggal Lahir: " + tanggalLahir + "\nJabatan: " + jabatan +
                        "\nGolongan: " + golongan + "\nAlamat: " + alamat;
                Toast.makeText(FormPegawaiActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        keluarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to launch the TransaksiActivity
                Intent intent = new Intent(FormPegawaiActivity.this, TransaksiActivity.class);

                // Start the TransaksiActivity
                startActivity(intent);
            }
        });

    }
}
