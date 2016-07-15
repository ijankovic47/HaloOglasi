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
public class Opstina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int opstinaId;
    private String ime;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "opstina", cascade = CascadeType.ALL)
    private List<Naselje> naselja = new ArrayList<>();

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getId() {
        return getOpstinaId();
    }

    public void setId(int opstinaId) {
        this.setOpstinaId(opstinaId);
    }

    public String toString() {
        return ime;
    }

    public int getOpstinaId() {
        return opstinaId;
    }

    public void setOpstinaId(int opstinaId) {
        this.opstinaId = opstinaId;
    }

    public List<Naselje> getNaselja() {
        return naselja;
    }

    public void setNaselja(List<Naselje> naselja) {
        this.naselja = naselja;
    }
}
