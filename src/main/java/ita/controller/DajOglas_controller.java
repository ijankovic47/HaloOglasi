package ita.controller;

import ita.model.AdresaM;
import ita.model.ClanM;
import ita.model.NaseljeM;
import ita.model.OpstinaM;
import ita.model.SlikaM;
import ita.model.StanM;
import ita.model.UlicaM;
import ita.service.DajOglas_service;
import ita.service.LogIn_service;
import ita.service.SetUp_service;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class DajOglas_controller { //Kontroler upravlja kompletnim procesom upisa novog oglasa od strane korisnika u bazu

    @Autowired
    DajOglas_service dajOglas_service;

    @Autowired
    SetUp_service setUp_service;

    @Autowired
    LogIn_service logIn_service;

    int ido = 0; //Promenljiva cuva indeks odabrane opstine u listi koja se na kraju dodaje "Stan" objektu posto atribut nije mapiran u spring formi

    List<OpstinaM> opstineM = null;

    @RequestMapping("/dajOglas")
    public String dajOglas(Model model, HttpServletRequest request) {

        request.getSession().setAttribute("errors", null);

        opstineM = setUp_service.setUp(); //Ucitavamo sve opstine iz baze

        model.addAttribute("opstine", opstineM);
        model.addAttribute("id", -1);
        model.addAttribute("lang", request.getAttribute("lang"));

        return "dajOglas";
    }

    @RequestMapping("/dajOglas2")
    public String dajOglas2(@RequestParam("opstina") int id, Model model, HttpServletRequest request) {

        ido = id;
        if (id == -1) {
            model.addAttribute("opstine", opstineM);
            model.addAttribute("id", -1);

            return "dajOglas";
        }
        NaseljeM n = new NaseljeM();
        n.setIme("Naselje?");
        n.setNaseljeId(0);
        List<NaseljeM> naseljaM1 = opstineM.get(id).getNaselja();             //Kreiramo listu naselja 
        List<NaseljeM> naseljaM = new ArrayList<>();
        naseljaM.add(n);
        for (NaseljeM naseljeM : naseljaM1) {
            naseljaM.add(naseljeM);
        }
        String[] brojSoba = {"Broj soba?", "0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5+"};
        String[] namestenost = {"Namestenost?", "namesteno", "polunamesteno", "prazno"};
        String[] nacinPlacanja = {"Nacin placanja?", "mesecno", "na 3 meseca", "na 6 meseci", "godisnje"};
        String[] grejanje = {"Grejanje?", "CG", "EG", "TA", "Gas", "Podno", "Norveski radijatori"};

        model.addAttribute("id", id);
        model.addAttribute("opstine", opstineM);
        model.addAttribute("naselja", naseljaM);

        StanM stanM = (StanM) request.getSession().getAttribute("stanM"); //Ukoliko vrsimo edit postojeceg objekta, on mora da se nalazi u sesiji

        if (stanM == null) {
            model.addAttribute("stanM", new StanM()); //Ukoliko je objekat "null" znaci da kreiramo novi oglas i spring forma je prazna
        } else {
            model.addAttribute("stanM", stanM); //Ukoliko objekat postoi u sesiji, znaci da editujemo oglas i spring forma ce biti popunjena njegovim informacijama
        }

        model.addAttribute("brojSoba", brojSoba);
        model.addAttribute("namestenost", namestenost);
        model.addAttribute("nacinPlacanja", nacinPlacanja);
        model.addAttribute("grejanje", grejanje);

        return "dajOglas";
    }

    @RequestMapping(value = "/dajOglas", method = RequestMethod.POST) //Metoda "hvata" objekat sa spring forme, obradjuje greske pri unosu i na kraju salje oglas u nize slojeve         //hidden polje cuva id iz baze
    public String saveOglas(@Valid @ModelAttribute("stanM") StanM stanM, BindingResult bindingResult, HttpServletRequest request, Model model, @RequestParam CommonsMultipartFile[] file, @RequestParam("id") int id) {

        if (stanM.getAdresa().getNaseljeM().getIme().equals("Naselje?")) {
            bindingResult.addError(new FieldError("stanM", "adresa.naseljeM.ime", "1"));
        }
        if (stanM.getBrojSoba().equals("Broj soba?")) {
            bindingResult.addError(new FieldError("stanM", "brojSoba", "3"));
        }
        if (stanM.getNamestenost().equals("Namestenost?")) {
            bindingResult.addError(new FieldError("stanM", "namestenost", "4"));   //Manualno kreiramo greske i ubacujemo ih u bindingResult listu kako bismo ih prikazali na osnovu imena polja koje nije prikladno popunjeno
        }
        if (stanM.getNacinPlacanja().equals("Nacin placanja?")) {
            bindingResult.addError(new FieldError("stanM", "nacinPlacanja", "5"));
        }
        if (stanM.getGrejanje().equals("Grejanje?")) {
            bindingResult.addError(new FieldError("stanM", "grejanje", "6"));
        }

        if (bindingResult.hasErrors()) {

            request.getSession().setAttribute("stanM", stanM);
            request.getSession().setAttribute("errors", bindingResult.getFieldErrors()); //Ako ima gresaka, prosledjujemo oglas koji je u toku obrade i listu gresaka nazad na spring formu

            return "redirect:/dajOglas2?opstina=" + ido;

        }

        stanM.setId(id); //Ukoliko editujemo postojeci oglas, on sadrzi svoj id iz baze i to je glavna razlika u "dao" sloju
        OpstinaM opstina = new OpstinaM();
        opstina = opstineM.get(ido);
        stanM.getAdresa().getNaseljeM().setOpstina(opstina);//Opstina se naknadno postavlja jer nije mapirana 
        ClanM clanM = (ClanM) request.getSession().getAttribute("clanM");
        stanM.getClan().setEmail(clanM.getEmail());// Naknadno se postavlja i "Clan" objekat (dovoljan je email)

        for (CommonsMultipartFile f : file) {
            if (!f.isEmpty()) {
                SlikaM slikaM = new SlikaM();
                slikaM.setSadrzaj(f.getBytes());       //Rukovanje multipart fajlovima
                stanM.getSlike().add(slikaM);
            }
        }

        boolean dajOglas = dajOglas_service.dajOglas(stanM); //Kreiranje novog oglasa ili modifikovanje starog

        if (dajOglas) {

            return "redirect:/tryLogIn?email=" + clanM.getEmail() + "&&password=" + clanM.getPassword(); //Ponovo se vrsi log in korisnika zbog osvezavanja liste oglasa i povratak na profil
        }
        model.addAttribute("lang", request.getAttribute("lang"));
        
        return "profil";
    }
}
