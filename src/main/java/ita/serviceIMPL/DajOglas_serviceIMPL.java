package ita.serviceIMPL;

import ita.dao.DajOglas_dao;
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
import ita.service.DajOglas_service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DajOglas_serviceIMPL implements DajOglas_service {

    @Autowired
    DajOglas_dao dajOglas_dao;

    @Override
    public boolean dajOglas(StanM stanM) {

        Stan stan = new Stan();
        stan = repackStan(stanM);

        return dajOglas_dao.dajOglas(stan);
    }

    private Stan repackStan(StanM stanM) {

        Stan stan = new Stan();

        stan.setBrojSoba(stanM.getBrojSoba());
        stan.setCena(stanM.getCena());
        stan.setDepozit(stanM.isDepozit());
        stan.setGrejanje(stanM.getGrejanje());
        stan.setId(stanM.getId());
        stan.setInternet(stanM.isInternet());
        stan.setKablovska(stanM.isKablovska());
        stan.setKlima(stanM.isKlima());
        stan.setKvadratura(stanM.getKvadratura());
        stan.setNacinPlacanja(stanM.getNacinPlacanja());
        stan.setNamestenost(stanM.getNamestenost());
        stan.setNaslov(stanM.getNaslov());
        stan.setOpis(stanM.getOpis());
        stan.setSprat(stanM.getSprat());
        stan.setTelefon(stanM.isTelefon());
        stan.setTerasa(stanM.isTerasa());
        stan.setMapa(stanM.getMapa());
        stan.setValidiran(stanM.isValidiran());

        stan.setAdresa(repackAdresa(stanM.getAdresa()));
        stan.setClan(repackClan(stanM.getClan()));
        stan.setSlike(repackSlike(stanM.getSlike()));

        return stan;
    }

    private Clan repackClan(ClanM clanM) {

        Clan clan = new Clan();

        clan.setEmail(clanM.getEmail());
        clan.setPassword(clanM.getPassword());
        clan.setTelefon(clanM.getTelefon());
        clan.setUsername(clanM.getUsername());
        clan.setRole(clanM.getRole());

        return clan;
    }

    private Adresa repackAdresa(AdresaM adresaM) {

        Adresa adresa = new Adresa();

        adresa.setNaselje(repackNaselje(adresaM.getNaseljeM()));
        adresa.setUlica(repackUlica(adresaM.getUlicaM()));

        return adresa;
    }

    private Naselje repackNaselje(NaseljeM naseljeM) {

        Naselje naselje = new Naselje();

        naselje.setIme(naseljeM.getIme());
        naselje.setNaseljeId(naseljeM.getNaseljeId());
        naselje.setOpstina(repackOpstina(naseljeM.getOpstina()));

        return naselje;
    }

    private Opstina repackOpstina(OpstinaM opstinaM) {

        Opstina opstina = new Opstina();
        opstina.setIme(opstinaM.getIme());
        opstina.setOpstinaId(opstinaM.getOpstinaId());

        return opstina;
    }

    private Ulica repackUlica(UlicaM ulicaM) {

        Ulica ulica = new Ulica();

        ulica.setIme(ulicaM.getIme());
        ulica.setId(ulicaM.getUlicaId());

        return ulica;
    }

    private List<Slika> repackSlike(List<SlikaM> slikeM) {

        List<Slika> slike = new ArrayList<>();

        Slika slika = new Slika();
        for (SlikaM slikaM : slikeM) {

            slika = repackSlika(slikaM);
            slike.add(slika);
        }
        return slike;
    }

    private Slika repackSlika(SlikaM slikaM) {

        Slika slika = new Slika();
        slika.setSadrzaj(slikaM.getSadrzaj());

        return slika;
    }
}
