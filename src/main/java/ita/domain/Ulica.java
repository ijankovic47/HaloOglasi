package ita.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ulica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ulicaId;
    private String ime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.ulica", cascade = CascadeType.ALL)
    private List<Adresa> adrese = new ArrayList<>();

    public int getId() {
        return ulicaId;
    }

    public void setId(int ulicaId) {
        this.ulicaId = ulicaId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
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
}
