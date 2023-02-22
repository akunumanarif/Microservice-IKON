package com.ikon.crudredis.model;

public class BookRequest {
    private String isbn;
    private String judul;
    private String penulis;
    private String deskripsi;
    private String kategori;


    public BookRequest(String isbn, String judul, String penulis, String deskripsi, String kategori) {
        this.isbn = isbn;
        this.judul = judul;
        this.penulis = penulis;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
