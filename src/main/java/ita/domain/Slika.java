package ita.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Slika {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private byte[] sadrzaj;

    @ManyToOne(fetch = FetchType.EAGER)
    private Stan stan;

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

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }

}
