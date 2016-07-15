package ita.serviceIMPL;

import ita.dao.LogIn_dao;
import ita.domain.Adresa;
import ita.domain.Clan;
import ita.domain.Naselje;
import ita.domain.Opstina;
import ita.domain.Slika;
import ita.domain.Stan;
import ita.domain.Ulica;
import ita.model.AdresaM;
import ita.model.ClanM;
import ita.model.NaseljeM;
import ita.model.OpstinaM;
import ita.model.SlikaM;
import ita.model.StanM;
import ita.model.UlicaM;
import ita.service.LogIn_service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogIn_serviceIMPL implements LogIn_service {

    @Autowired
    LogIn_dao logIn_dao;

    @Override
    public ClanM logIn(String email, String password) {

        ClanM clanM = new ClanM();
        Clan clan = logIn_dao.logIn(email, password);

        clanM.setEmail(clan.getEmail());
        clanM.setPassword(clan.getPassword());
        clanM.setTelefon(clan.getTelefon());
        clanM.setUsername(clan.getUsername());
        clanM.setRole(clan.getRole());

        clanM.setStanovi(repackStanovi(clan.getStanovi()));

        return clanM;
    }

    public List<StanM> repackStanovi(List<Stan> stanovi) {

        List<StanM> stanoviM = new ArrayList<>();
        StanM stanM = new StanM();
        for (Stan stan : stanovi) {

            stanM = repackStan(stan);
            stanoviM.add(stanM);

        }
        return stanoviM;
    }

    public StanM repackStan(Stan stan) {

        StanM stanM = new StanM();

        stanM.setBrojSoba(stan.getBrojSoba());
        stanM.setCena(stan.getCena());
        stanM.setDepozit(stan.isDepozit());
        stanM.setGrejanje(stan.getGrejanje());
        stanM.setId(stan.getId());
        stanM.setInternet(stan.isInternet());
        stanM.setKablovska(stan.isKablovska());
        stanM.setKlima(stan.isKlima());
        stanM.setKvadratura(stan.getKvadratura());
        stanM.setNacinPlacanja(stan.getNacinPlacanja());
        stanM.setNamestenost(stan.getNamestenost());
        stanM.setNaslov(stan.getNaslov());
        stanM.setOpis(stan.getOpis());
        stanM.setSprat(stan.getSprat());
        stanM.setTelefon(stan.isTelefon());
        stanM.setTerasa(stan.isTerasa());
        stanM.setMapa(stan.getMapa());
        stanM.setValidiran(stan.isValidiran());

        stanM.setClan(repackClan(stan.getClan()));
        stanM.setAdresa(repackAdresa(stan.getAdresa()));
        stanM.setSlike(repackSlike(stan.getSlike()));

        return stanM;
    }
    
    public ClanM repackClan(Clan clan){
        
        ClanM clanM=new ClanM();
        clanM.setEmail(clan.getEmail());
        clanM.setPassword(clan.getPassword());
        clanM.setRole(clan.getRole());
        clanM.setTelefon(clan.getTelefon());
        clanM.setUsername(clan.getUsername());
        
        return clanM;
    }

    public AdresaM repackAdresa(Adresa adresa) {

        AdresaM adresaM = new AdresaM();

        adresaM.setNaseljeM(repackNaselje(adresa.getNaselje()));
        adresaM.setUlicaM(repackUlica(adresa.getUlica()));

        return adresaM;
    }

    public List<SlikaM> repackSlike(List<Slika> slike) {

        List<SlikaM> slikeM = new ArrayList<>();
        SlikaM slikaM = new SlikaM();

        for (Slika slika : slike) {

            slikaM = repackSlika(slika);
            slikeM.add(slikaM);
        }

        return slikeM;
    }

    public SlikaM repackSlika(Slika slika) {

        SlikaM slikaM = new SlikaM();

        slikaM.setId(slika.getId());

        return slikaM;
    }

    public NaseljeM repackNaselje(Naselje naselje) {

        NaseljeM naseljeM = new NaseljeM();

        naseljeM.setIme(naselje.getIme());
        naseljeM.setOpstina(repackOpstina(naselje.getOpstina()));

        return naseljeM;
    }

    public UlicaM repackUlica(Ulica ulica) {

        UlicaM ulicaM = new UlicaM();

        ulicaM.setIme(ulica.getIme());

        return ulicaM;
    }

    public OpstinaM repackOpstina(Opstina opstina) {

        OpstinaM opstinaM = new OpstinaM();

        opstinaM.setIme(opstina.getIme());

        return opstinaM;
    }
}
