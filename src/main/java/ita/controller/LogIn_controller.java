package ita.controller;

import ita.model.ClanM;
import ita.model.StanM;
import ita.service.DeleteStan_service;
import ita.service.LogIn_service;
import ita.service.Search_service;
import ita.service.Validate_service;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogIn_controller {  //Kontroler upravlja prikazom svih izdatih oglasa od strane korisnika i akcijama koje su mu omogucene na osnovu uloge 

    @Autowired
    LogIn_service logIn_service;

    @Autowired
    Search_service searchService;

    ClanM clanM = new ClanM();

    @Autowired
    DeleteStan_service deleteStan_service;

    @Autowired
    Validate_service validate_service;

    @RequestMapping("/logIn") //Prikazuje stranu sa poljima "email" i "password"
    public String LogIn(HttpServletRequest request, Model model) {
        
        model.addAttribute("lang", request.getAttribute("lang"));

        return "logIn";
    }

    @RequestMapping("/tryLogIn") 
    public String tryLogIn(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request) {

        request.getSession().setAttribute("stanM", null);  //Kada se ide na back iz edita ostaje popunjen objekat u sesiji!

        clanM = logIn_service.logIn(email, password);  //Vraca konkretnog korisnika ili prazan objekat ukoliko nema podudarnosti

        if (clanM.getEmail() != null && clanM.getRole().equals("user")) {

            request.getSession().setAttribute("clanM", clanM);  // Log in korisnika

            return "profil";
        }
        if (clanM.getEmail() != null && clanM.getRole().equals("admin")) {    //Log in admina

            List<StanM> stanoviM = searchService.adminSearch(); //Metoda vraca listu svih izdatih oglasa od strane svih korisnika 
            clanM.setStanovi(stanoviM); //Lista se prosledjuje adminu

            request.getSession().setAttribute("clanM", clanM);    

            return "profil";
        }

        return "logIn";        //U slucaju da ne postoji korisnik samo se vraca "logIn" strana
    }

    @RequestMapping("/opsirnije") //Prikaz svih informacija o izabranom oglasu, slicno kao kod slobodne pretrage
    public String opsirnije(@RequestParam("index") int index, Model model, HttpServletRequest request) {

        clanM = (ClanM) request.getSession().getAttribute("clanM");
        StanM stanM = clanM.getStanovi().get(index);

        model.addAttribute("stanM", stanM);

        model.addAttribute("lang", request.getSession().getAttribute("lang"));
        
        return "opsirnije";
    }

    @RequestMapping("/delete") //Metoda za brisanje oglasa na osnovu id-a u bazi od strane korisnika ili admina
    public String delete(@RequestParam("id") int id, HttpServletRequest request) {

        deleteStan_service.deleteStan(id);

        if (clanM.getRole().equals("admin")) { //Ako oglas brise admin, ponovo se ucitavaju svi izdati oglasi

            List<StanM> stanoviM = searchService.adminSearch();
            clanM.setStanovi(stanoviM);
            request.getSession().setAttribute("clanM", clanM);
            
        } else { //Ako oglas brise korisnik, ponovo se vrsi log in da bi se osvezila lista izdatih oglasa

            clanM = logIn_service.logIn(clanM.getEmail(), clanM.getPassword());
            request.getSession().setAttribute("clanM", clanM);
        }

        return "profil";
    }

    @RequestMapping("/validate") //Metoda za validaciju oglasa na osnovu id-a, vrsi je admin i oglas jeste u bazi ali nije vidljiv pri slobodnoj pretrazi ako nije validiran
    public String validate(@RequestParam("id") int id, HttpServletRequest request) {

        validate_service.validate(id);

        List<StanM> stanoviM = searchService.adminSearch(); //Ponovno ucitavanje svih oglasa

        clanM.setStanovi(stanoviM);

        request.getSession().setAttribute("clanM", clanM);

        return "profil";
    }

    @RequestMapping("/logOut") //Povratak na "logIn" stranu
    public String logOut(HttpServletRequest request) {

        request.getSession().setAttribute("clanM", null);

        return "logIn";
    }

    @RequestMapping("/back")//  Povratak na slobodnu pretragu
    public String back() {

        return "home";
    }

    @RequestMapping("/edit") //Metoda za promenu informacija o postojecem oglasu
    public String edit(@RequestParam("index") int index, HttpServletRequest request) {

        StanM stanM = clanM.getStanovi().get(index); //Uzimamo iz liste konkretan oglas na osnovu indeksa
        request.getSession().setAttribute("stanM", stanM);

        request.getSession().setAttribute("errors", null); //Postavljamo listu gresaka koje nastaju prilikom spring validacije polja na "null"
        
        return "redirect:/dajOglas";
    }
}
