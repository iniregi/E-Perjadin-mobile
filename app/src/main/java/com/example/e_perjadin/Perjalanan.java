package com.example.e_perjadin;

public class Perjalanan {
    private int id;
    private String noSuratTugas;
    private String nama;
    private String nip;
    private String tempatPerjadin;
    private String tanggalBerangkat;
    private String tanggalSelesai;
    private String lamaDinas;
    private String kegiatanPerjadin;

    public Perjalanan(int id, String noSuratTugas, String nama, String nip, String tempatPerjadin, String tanggalBerangkat, String tanggalSelesai, String lamaDinas, String kegiatanPerjadin) {
        this.id = id;
        this.noSuratTugas = noSuratTugas;
        this.nama = nama;
        this.nip = nip;
        this.tempatPerjadin = tempatPerjadin;
        this.tanggalBerangkat = tanggalBerangkat;
        this.tanggalSelesai = tanggalSelesai;
        this.lamaDinas = lamaDinas;
        this.kegiatanPerjadin = kegiatanPerjadin;
    }

    public int getId() {
        return id;
    }

    public String getNoSuratTugas() {
        return noSuratTugas;
    }

    public String getNama() {
        return nama;
    }

    public String getNip() {
        return nip;
    }

    public String getTempatPerjadin() {
        return tempatPerjadin;
    }

    public String getTanggalBerangkat() {
        return tanggalBerangkat;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }

    public String getLamaDinas() {
        return lamaDinas;
    }

    public String getKegiatanPerjadin() {
        return kegiatanPerjadin;
    }
}
