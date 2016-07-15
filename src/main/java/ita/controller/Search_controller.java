package ita.controller;

import ita.model.StanM;
import ita.service.Search_service;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Search_controller { //Kontroler zaduzen za rukovanje slobodnom pretragom po parametrima

    @Autowired
    Search_service search_service;

    List<StanM> stanoviM = new ArrayList<>();

    @RequestMapping("/search")     //parametri za pretragu uneti na "home" strani, nijedan nije obavezan
    public String search(@RequestParam("naselje") int naseljeId, @RequestParam("cena") Object cena, @RequestParam("kvadratura") Object kvadratura,
            @RequestParam("brSoba") String brSoba, Model model, HttpServletRequest request) {

        int cenaInt = 0;
        int kvadraturaInt = 0;
        if (cena.equals("")) {
            cenaInt = 0;
        } else {
            cenaInt = Integer.valueOf(cena.toString());        //polja "cena" i "kvadratura" su tipa "number" i vracaju prazan string u slucaju da nisu popunjena"
        }
        if (kvadratura.equals("")) {;
            kvadraturaInt = 0;
        } else {
            kvadraturaInt = Integer.valueOf(kvadratura.toString());
        }
        stanoviM = search_service.search(cenaInt, kvadraturaInt, naseljeId, brSoba);  //lista stanova koji odgovaraju unetim parametrima
        model.addAttribute("stanovi", stanoviM);
        
        model.addAttribute("lang", request.getSession().getAttribute("lang"));  

        return "search";
    }

    @RequestMapping("opsirnije2") //svaki objekat iz liste stanova ima mogucnost opsirnijeg pregleda na osnovu indeksa u listi
    public String opstirnije2(@RequestParam("index") int index, Model model, HttpServletRequest request) {

        StanM stanM = stanoviM.get(index);
        model.addAttribute("stanM", stanM);   //preikaz svih informacija o izabranom objektu

        model.addAttribute("lang", request.getAttribute("lang"));
        
        return "opsirnije";
    }

    @RequestMapping("/goBack") //vraca korak nazad i prikazuje listu stanova koji odgovaraju unetim kriterijumima
    public String back(Model model) {

        model.addAttribute("stanovi", stanoviM);

        return "search";
    }

}
