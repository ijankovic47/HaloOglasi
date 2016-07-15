package ita.controller;

import ita.model.ClanM;
import ita.service.SignUp_service;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUp_controller { //Kontroler zaduzen za kreiranje novih korisnika koji imaju mogucnost postavljanja novih oglasa

    @Autowired
    SignUp_service signUp_service;

    @RequestMapping("/signUp")
    public String signUp(Model model, HttpServletRequest request) {
        
        model.addAttribute("lang", request.getAttribute("lang"));

        model.addAttribute("clanM", new ClanM());    //"signUp" strana koristi spring formu tako da prosledjujemo prazan objekat 

        return "signUp";
    }

    @RequestMapping(value = "/trySignUp", method = RequestMethod.POST)   //Metoda uzima popunjen objekat i vrsi validaciju na osnovu anotacija u klasi
    public String profil(@Valid @ModelAttribute("clanM") ClanM clanM, BindingResult bindingResult, Model model, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {

            return "signUp";            //Ako ima gresaka ne ide dalje
        }

        boolean signUp = signUp_service.signUp(clanM);    //Ako je "email" jedinstven vrsi se upis novog korisnika (vraca true)

        if (signUp == true) {
            request.getSession().setAttribute("clanM", clanM);  //Postavlja novog clana u sesiju i prikazuje njegovu profil sranu
            
            return "profil";
            
        } else {
            model.addAttribute("signUp", "Vec postoji clan sa tim email-om u bazi"); //Ako "email" nije jedinstven vraca se na "signUp" stranu
            
            return "signUp";
        }
    }
}
