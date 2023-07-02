package com.example.e_perjadin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "perjalanan.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the "perjalanan" table
        String createTableQuery = "CREATE TABLE perjalanan (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "no_surat_tugas TEXT," +
                "nama TEXT," +
                "nip TEXT," +
                "tempat_perjadin TEXT," +
                "tanggal_berangkat TEXT," +
                "tanggal_selesai TEXT," +
                "lama_dinas TEXT," +
                "kegiatan_perjadin TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the "perjalanan" table if it exists
        String dropTableQuery = "DROP TABLE IF EXISTS perjalanan";
        db.execSQL(dropTableQuery);
        onCreate(db);
    }

    public long insertPerjalanan(Perjalanan perjalanan) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("no_surat_tugas", perjalanan.getNoSuratTugas());
        values.put("nama", perjalanan.getNama());
        values.put("nip", perjalanan.getNip());
        values.put("tempat_perjadin", perjalanan.getTempatPerjadin());
        values.put("tanggal_berangkat", perjalanan.getTanggalBerangkat());
        values.put("tanggal_selesai", perjalanan.getTanggalSelesai());
        values.put("lama_dinas", perjalanan.getLamaDinas());
        values.put("kegiatan_perjadin", perjalanan.getKegiatanPerjadin());
        return db.insert("perjalanan", null, values);
    }

    public Cursor getAllPerjalanan() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query("perjalanan", null, null, null, null, null, null);
    }
}
