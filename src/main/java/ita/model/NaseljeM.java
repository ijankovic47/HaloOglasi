package ita.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Pattern;

public class NaseljeM {

    private int naseljeId;
    
    @Pattern(regexp = "^[a-zA-Z\\-]+$", message = "1")
    private String ime;
    private OpstinaM opstina = new OpstinaM();
    private List<AdresaM> adrese = new ArrayList<>();

    public int getNaseljeId() {
        return naseljeId;
    }

    public void setNaseljeId(int naseljeId) {
        this.naseljeId = naseljeId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public OpstinaM getOpstina() {
        return opstina;
    }

    public void setOpstina(OpstinaM opstina) {
        this.opstina = opstina;
    }

    public List<AdresaM> getAdrese() {
        return adrese;
    }

    public void setAdrese(List<AdresaM> adrese) {
        this.adrese = adrese;
    }

    public String toString() {
        return ime;
    }
}
