package com.example.e_perjadin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TransaksiActivity extends AppCompatActivity {
    private EditText noSuratTugasEditText;
    private EditText nipEditText;
    private EditText tempatPerjadinEditText;
    private EditText tanggalBerangkatEditText;
    private EditText tanggalSelesaiEditText;
    private EditText lamaDinasEditText;
    private EditText kegiatanPerjadinEditText;
    private EditText biayaPenginapanEditText;
    private EditText biayaTransportasiEditText;
    private EditText uangHarianEditText;
    private EditText uangPendampingEditText;
    private EditText totalBiayaEditText;
    private Button resetButton;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        // Initialize views
        noSuratTugasEditText = findViewById(R.id.noSuratTugasEditText);
        nipEditText = findViewById(R.id.nipEditText);
        tempatPerjadinEditText = findViewById(R.id.tempatPerjadinEditText);
        tanggalBerangkatEditText = findViewById(R.id.tanggalBerangkatEditText);
        tanggalSelesaiEditText = findViewById(R.id.tanggalSelesaiEditText);
        lamaDinasEditText = findViewById(R.id.lamaDinasEditText);
        kegiatanPerjadinEditText = findViewById(R.id.kegiatanPerjadinEditText);
        biayaPenginapanEditText = findViewById(R.id.biayaPenginapanEditText);
        biayaTransportasiEditText = findViewById(R.id.biayaTransportasiEditText);
        uangHarianEditText = findViewById(R.id.uangHarianEditText);
        uangPendampingEditText = findViewById(R.id.uangPendampingEditText);
        totalBiayaEditText = findViewById(R.id.totalBiayaEditText);
        resetButton = findViewById(R.id.resetButton);
        submitButton = findViewById(R.id.submitButton);

        // Reset button click listener
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });

        // Submit button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void resetFields() {
        // Clear all input fields
        noSuratTugasEditText.setText("");
        nipEditText.setText("");
        tempatPerjadinEditText.setText("");
        tanggalBerangkatEditText.setText("");
        tanggalSelesaiEditText.setText("");
        lamaDinasEditText.setText("");
        kegiatanPerjadinEditText.setText("");
        biayaPenginapanEditText.setText("");
        biayaTransportasiEditText.setText("");
        uangHarianEditText.setText("");
        uangPendampingEditText.setText("");
        totalBiayaEditText.setText("");
    }

    private void submitForm() {
        // Get the values entered by the user
        String noSuratTugas = noSuratTugasEditText.getText().toString();
        String nip = nipEditText.getText().toString();
        String tempatPerjadin = tempatPerjadinEditText.getText().toString();
        String tanggalBerangkat = tanggalBerangkatEditText.getText().toString();
        String tanggalSelesai = tanggalSelesaiEditText.getText().toString();
        String lamaDinas = lamaDinasEditText.getText().toString();
        String kegiatanPerjadin = kegiatanPerjadinEditText.getText().toString();
        String biayaPenginapan = biayaPenginapanEditText.getText().toString();
        String biayaTransportasi = biayaTransportasiEditText.getText().toString();
        String uangHarian = uangHarianEditText.getText().toString();
        String uangPendamping = uangPendampingEditText.getText().toString();
        String totalBiaya = totalBiayaEditText.getText().toString();

        // Perform any validation or processing logic here

        // Display a toast or perform any other action to indicate successful submission
    }
}
