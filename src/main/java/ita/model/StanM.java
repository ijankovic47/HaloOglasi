package ita.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class StanM implements Serializable{

    private int id;
    
    @Size(min = 5, max = 30, message = "2")
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

    private boolean depozit;
    private boolean terasa;
    private boolean klima;
    private boolean telefon;
    private boolean kablovska;
    private boolean internet;

    private boolean validiran;

    private ClanM clan = new ClanM();
    private AdresaM adresa = new AdresaM();
    private List<SlikaM> slike = new ArrayList<>();

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

    public ClanM getClan() {
        return clan;
    }

    public void setClan(ClanM clan) {
        this.clan = clan;
    }

    public AdresaM getAdresa() {
        return adresa;
    }

    public void setAdresa(AdresaM adresa) {
        this.adresa = adresa;
    }

    public List<SlikaM> getSlike() {
        return slike;
    }

    public void setSlike(List<SlikaM> slike) {
        this.slike = slike;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public boolean isValidiran() {
        return validiran;
    }

    public void setValidiran(boolean validiran) {
        this.validiran = validiran;
    }
}
