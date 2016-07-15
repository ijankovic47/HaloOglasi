package ita.controller;

import ita.localization.Localization;
import ita.model.NaseljeM;
import ita.model.OpstinaM;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import ita.service.SetUp_service;
import java.util.HashMap;
import javafx.scene.layout.BorderStroke;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SetUp_controller {        //Prvi kontroler koji gadja aplikacija, ucitava sve opstine iz baze i vraca "home" pogled koji sadrzi formu za slobodnu pretragu

    @Autowired
    SetUp_service setUp;

    List<OpstinaM> opstineM = null;

    HashMap<String, String> lang = null;

    Cookie cookie = null;
    

    Localization loc = new Localization();

    @RequestMapping("/")
    public String getHome(Model model, HttpServletRequest request) {

        Cookie[] c=request.getCookies();
        if(c!=null){
        for (int i=0;i<c.length;i++) {
            if (c[i].getName().equals("lang")) {           //Trazi se kolacic sa imenom "lang" za lokalizaciju aplikacije
                cookie = c[i];
            }
        }
        if (cookie == null) {
            lang = loc.getLocales("srb");           //Ako kolacic ne postoji postavlja se srpski jezik kao podrazumevani
        } else {
            lang=loc.getLocales(cookie.getValue()); //Ako kolacic postoji postavlja se lokalizacija na osnovu njegove vrednosti
        }}
        else{
            lang = loc.getLocales("srb");
        }

        request.getSession().setAttribute("lang", lang);        //Postavlja se mapa sa odabranim prevodom u sesiju zbog dostupnosti u celoj aplikaciji
        
        model.addAttribute("lang", request.getSession().getAttribute("lang"));      //Mapa mora u model svake jsp strane jer nije vidljiva iz sesije ? 

        opstineM = setUp.setUp();       //Ucitava sve opstine iz baze

        model.addAttribute("opstine", opstineM);
        model.addAttribute("id", -1);   //id za eventualni preselect na osnovu broja iteracije

        return "home";
    }

    @RequestMapping("/loadForm2")
    public String getHome2(@RequestParam("opstina") int id, Model model) {

        if (id == -1) {
            model.addAttribute("opstine", opstineM);
            model.addAttribute("id", -1);                   //ako opstina nije odabrana ne ide dalje

            return "home";
        }
        List<NaseljeM> naseljaM = opstineM.get(id).getNaselja();   //uzimanje liste naselja iz odabrane opstine
        model.addAttribute("id", id);
        model.addAttribute("opstine", opstineM);
        model.addAttribute("naselja", naseljaM);

        return "home";
    }
}
