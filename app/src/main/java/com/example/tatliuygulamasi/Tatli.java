package com.example.tatliuygulamasi;

public class Tatli {
    String isim;
    int resim;
    String aciklama;

    public Tatli(String isim, int resim, String aciklama) {
        this.isim = isim;
        this.resim = resim;
        this.aciklama = aciklama;
    }

    public Tatli(int id, String isim, String aciklama, String resim, String video, String malzemeler) {
    }

    public String getIsim() {
        return isim;
    }

    public int getResim() {
        return resim;
    }

    public String getAciklama() {
        return aciklama;
    }

}
