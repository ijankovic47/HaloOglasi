package ita.model;

public class SlikaM {

    private int id;
    private byte[] sadrzaj;

    private StanM stan = new StanM();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(byte[] sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public StanM getStan() {
        return stan;
    }

    public void setStan(StanM stan) {
        this.stan = stan;
    }
}
