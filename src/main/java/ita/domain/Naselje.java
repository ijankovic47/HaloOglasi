package ita.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Naselje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int naseljeId;
    private String ime;

    @ManyToOne(cascade = CascadeType.ALL)
    private Opstina opstina;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.naselje", cascade = CascadeType.ALL)
    private List<Adresa> adrese = new ArrayList<>();

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getId() {
        return getNaseljeId();
    }

    public void setId(int naseljeId) {
        this.setNaseljeId(naseljeId);
    }

    public List<Adresa> getAdrese() {
        return adrese;
    }

    public void setAdrese(List<Adresa> adrese) {
        this.adrese = adrese;
    }

    public String toString() {
        return ime;
    }

    public int getNaseljeId() {
        return naseljeId;
    }

    public void setNaseljeId(int naseljeId) {
        this.naseljeId = naseljeId;
    }

    public Opstina getOpstina() {
        return opstina;
    }

    public void setOpstina(Opstina opstina) {
        this.opstina = opstina;
    }
}
