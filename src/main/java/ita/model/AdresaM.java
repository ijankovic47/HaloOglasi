package ita.model;

public class AdresaM {

    private NaseljeM naseljeM = new NaseljeM();
    private UlicaM ulicaM = new UlicaM();

    public NaseljeM getNaseljeM() {
        return naseljeM;
    }

    public void setNaseljeM(NaseljeM naseljeM) {
        this.naseljeM = naseljeM;
    }

    public UlicaM getUlicaM() {
        return ulicaM;
    }

    public void setUlicaM(UlicaM ulicaM) {
        this.ulicaM = ulicaM;
    }
}
