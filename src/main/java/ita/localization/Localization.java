package ita.localization;

import java.util.HashMap;

public class Localization {
    
    private HashMap<String, HashMap<String, String>> locales=new HashMap<>();
    
    public Localization(){
        
        HashMap<String, String> srb=new HashMap<>();
        HashMap<String, String> eng=new HashMap<>();
        
        srb.put("h1", "Unesite parametre za pretragu !");
        srb.put("potvrdi", "Potvrdi");
        srb.put("cenaDo", "Cena do:");
        srb.put("kvadraturaOd", "Kvadratura od:");
        srb.put("nazad", "Nazad");
        srb.put("sifra", "Sifra:");
        srb.put("ulogujSe", "Uloguj se");
        srb.put("prijaviSe", "Prijavi se");
        srb.put("izlogujSe", "Izloguj se");
        srb.put("ulogovanKao", "Ulogovan kao:");
        srb.put("nemaOglasa", "Nema izdatih oglasa !");
        srb.put("vasiOglasi", "Vasi oglasi:");
        srb.put("cena", "Cena:");
        srb.put("validiran", "Validiran:");
        srb.put("opsirnije", "Opsirnije");
        srb.put("obrisi", "Obrisi oglas");
        srb.put("edituj", "Edituj");
        srb.put("validiraj", "Validiraj");
        srb.put("noviOglas", "Kreiraj novi oglas");
        srb.put("nemaOglasa2", "Nema oglasa koji odgovaraju zadatim kriterijumima !");
        srb.put("vasiOglasi2", "Oglasi koji odgovaraju kriterijumima:");
        srb.put("kvadratura", "Kvadratura:");
        srb.put("brojSoba", "Broj soba:");
        srb.put("grejanje", "Grejanje:");
        srb.put("nacinPlacanja", "Nacin placanja:");
        srb.put("namestenost", "Namestenost:");
        srb.put("sprat", "Sprat:");
        srb.put("telefon", "Telefon:");
        srb.put("depozit", "Depozit");
        srb.put("klima", "Klima");
        srb.put("kablovska", "Kablovska");
        srb.put("terasa", "Terasa");
        srb.put("naslov", "Naslov:");
        srb.put("ulicaIbroj", "Ulica i broj:");
        srb.put("opis", "Opis:");
        srb.put("dodatno", "Dodatno:");
        srb.put("linkMapa", "Unesite link mape koju zelite da embedujete:");
        srb.put("korisnickoIme", "Korisnicko ime:");
        
        eng.put("h1", "Enter parameters for search !");
        eng.put("potvrdi", "Confirm");
        eng.put("cenaDo", "Price up to:");
        eng.put("kvadraturaOd", "Quadrature min:");
        eng.put("nazad", "Back");
        eng.put("sifra", "Password");
        eng.put("ulogujSe", "Log in");
        eng.put("prijaviSe", "Sign up");
        eng.put("izlogujSe", "Log out");
        eng.put("ulogovanKao", "Logged in as:");
        eng.put("nemaOglasa", "No ads !");
        eng.put("vasiOglasi", "Your ads:");
        eng.put("cena", "Price:");
        eng.put("validiran", "Validated:");
        eng.put("opsirnije", "Read more");
        eng.put("obrisi", "Delete ad");
        eng.put("edituj", "Edit");
        eng.put("validiraj", "Validate");
        eng.put("noviOglas", "Create new ad");
        eng.put("nemaOglasa2", "No ad match inserted criteria !");
        eng.put("vasiOglasi2", "Ads that match the criteria:");
        eng.put("kvadratura", "Quadrature:");
        eng.put("brojSoba", "Number of rooms:");
        eng.put("grejanje", "Heating:");
        eng.put("nacinPlacanja", "Payment:");
        eng.put("namestenost", "Furnishing:");
        eng.put("sprat", "Floor:");
        eng.put("telefon", "Telephone:");
        eng.put("depozit", "Deposit");
        eng.put("klima", "Air-conditioner");
        eng.put("kablovska", "Cable tv");
        eng.put("terasa", "Terrace");
        eng.put("naslov", "Title:");
        eng.put("ulicaIbroj", "Street name and number:");
        eng.put("opis", "Description:");
        eng.put("dodatno", "In addition:");
        eng.put("linkMapa", "Insert link of the map you want to embed");
        eng.put("korisnickoIme", "Username:");
        
        locales.put("srb", srb);
        locales.put("eng", eng);
        
    }
    public HashMap<String, String> getLocales(String lang){
        
        return locales.get(lang);
    }
    
}
