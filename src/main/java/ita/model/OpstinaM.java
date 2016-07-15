package ita.model;

import java.util.ArrayList;
import java.util.List;

public class OpstinaM {

    private int opstinaId;
    private String ime;
    private List<NaseljeM> naselja = new ArrayList<>();

    public int getOpstinaId() {
        return opstinaId;
    }

    public void setOpstinaId(int opstinaId) {
        this.opstinaId = opstinaId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public List<NaseljeM> getNaselja() {
        return naselja;
    }

    public void setNaselja(List<NaseljeM> naselja) {
        this.naselja = naselja;
    }

    public String toString() {
        return ime;
    }
}
