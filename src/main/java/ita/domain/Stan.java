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
import javax.persistence.OneToOne;

@Entity
public class Stan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String naslov;
    private int cena;
    private int kvadratura;
    private String brojSoba;
    private String opis;
    private String grejanje;
    private String namestenost;
    private int sprat;
    private String nacinPlacanja;
    private String mapa;

    private boolean depozit = false;
    private boolean terasa = false;
    private boolean klima = false;
    private boolean telefon = false;
    private boolean kablovska = false;
    private boolean internet = false;

    private boolean validiran = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Clan clan;

    @ManyToOne(fetch = FetchType.EAGER)
    private Adresa adresa;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "stan")
    private List<Slika> slike = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(int kvadratura) {
        this.kvadratura = kvadratura;
    }

    public String getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(String brojSoba) {
        this.brojSoba = brojSoba;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getGrejanje() {
        return grejanje;
    }

    public void setGrejanje(String grejanje) {
        this.grejanje = grejanje;
    }

    public String getNamestenost() {
        return namestenost;
    }

    public void setNamestenost(String namestenost) {
        this.namestenost = namestenost;
    }

    public int getSprat() {
        return sprat;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }

    public String getNacinPlacanja() {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(String nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public boolean isDepozit() {
        return depozit;
    }

    public void setDepozit(boolean depozit) {
        this.depozit = depozit;
    }

    public boolean isTerasa() {
        return terasa;
    }

    public void setTerasa(boolean terasa) {
        this.terasa = terasa;
    }

    public boolean isKlima() {
        return klima;
    }

    public void setKlima(boolean klima) {
        this.klima = klima;
    }

    public boolean isTelefon() {
        return telefon;
    }

    public void setTelefon(boolean telefon) {
        this.telefon = telefon;
    }

    public boolean isKablovska() {
        return kablovska;
    }

    public void setKablovska(boolean kablovska) {
        this.kablovska = kablovska;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public List<Slika> getSlike() {
        return slike;
    }

    public void setSlike(List<Slika> slike) {
        this.slike = slike;
    }

    public boolean isValidiran() {
        return validiran;
    }

    public void setValidiran(boolean validiran) {
        this.validiran = validiran;
    }
}
