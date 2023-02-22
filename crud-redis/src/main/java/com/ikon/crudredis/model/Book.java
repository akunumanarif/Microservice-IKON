package com.ikon.crudredis.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Books")
public class Book {
    private String id;
    private String isbn;
    private String judul;
    private String penulis;
    private String deskripsi;
    private String kategori;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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



    public Book(String id, String isbn, String judul, String penulis, String deskripsi, String kategori) {
        this.id = id;
        this.isbn = isbn;
        this.judul = judul;
        this.penulis = penulis;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
    }


}
