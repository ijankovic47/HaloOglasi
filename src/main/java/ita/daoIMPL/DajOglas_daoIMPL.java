package ita.daoIMPL;

import ita.dao.DajOglas_dao;
import ita.domain.Adresa;
import ita.domain.Clan;
import ita.domain.Naselje;
import ita.domain.Opstina;
import ita.domain.Slika;
import ita.domain.Stan;
import ita.domain.Ulica;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DajOglas_daoIMPL implements DajOglas_dao {

    @Autowired
    SessionFactory sessionFactory;
    Transaction t = null;
    Query q = null;

    @Override
    public boolean dajOglas(Stan stan) {

        Session s = sessionFactory.getCurrentSession();
        t = s.beginTransaction();

        Opstina opstina = stan.getAdresa().getNaselje().getOpstina();
        Naselje naselje = stan.getAdresa().getNaselje();
        Ulica ulica = stan.getAdresa().getUlica();
        Clan clan = stan.getClan();

        q = s.createQuery("from Opstina where ime='" + opstina.getIme() + "'");
        if (q.list().size() > 0) {
            opstina = (Opstina) q.list().get(0);
        } else {
            s.save(opstina);
            q = s.createQuery("from Opstina where ime='" + opstina.getIme() + "'");
            opstina = (Opstina) q.list().get(0);
        }

        q = s.createQuery("from Naselje where ime='" + naselje.getIme() + "'");
        if (q.list().size() > 0) {
            naselje = (Naselje) q.list().get(0);
        } else {
            s.save(naselje);
            q = s.createQuery("from Naselje where ime='" + naselje.getIme() + "'");
            naselje = (Naselje) q.list().get(0);
        }

        q = s.createQuery("from Ulica where ime='" + ulica.getIme() + "'");
        if (q.list().size() > 0) {
            ulica = (Ulica) q.list().get(0);
        } else {
            s.save(ulica);
            q = s.createQuery("from Ulica where ime='" + ulica.getIme() + "'");
            ulica = (Ulica) q.list().get(0);

        }
        naselje.setOpstina(opstina);
        Adresa adresa = new Adresa();
        adresa.setNaselje(naselje);
        adresa.setUlica(ulica);

        q = s.createQuery("from Adresa where naseljeId='" + naselje.getId() + "' and ulicaId='" + ulica.getId() + "'");
        if (q.list().size() > 0) {
            adresa = (Adresa) q.list().get(0);
        } else {
            s.save(adresa);
            q = s.createQuery("from Adresa where naseljeId='" + naselje.getId() + "' and ulicaId='" + ulica.getId() + "'");
            adresa = (Adresa) q.list().get(0);
        }

        q = s.createQuery("from Clan where email='" + clan.getEmail() + "'");
        if (q.list().size() > 0) {
            clan = (Clan) q.list().get(0);
        } else {
            s.save(clan);
            q = s.createQuery("from Clan where email='" + clan.getEmail() + "'");
            clan = clan = (Clan) q.list().get(0);
        }

        stan.setClan(clan);
        stan.setAdresa(adresa);
        System.out.println(stan.getId());
        if (stan.getId() > 0) {
            
            q = s.createQuery("from Stan where id='" + stan.getId() + "'");
            Stan stanPom=(Stan) q.list().get(0);
            getSet(stanPom, stan);
            s.update(stanPom);
            
        } else {
            Integer id = (Integer) s.save(stan);
            q = s.createQuery("from Stan where id='" + id + "'");
        }
        Stan st = (Stan) q.list().get(0);

        List<Slika> slike = stan.getSlike();

        for (Slika slika : slike) {
            slika.setStan(st);
            s.save(slika);
        }

        t.commit();

        return true;
    }
    
    private void getSet(Stan stan1, Stan stan2){
        
        stan1.setAdresa(stan2.getAdresa());
        stan1.setBrojSoba(stan2.getBrojSoba());
        stan1.setCena(stan2.getCena());
        stan1.setDepozit(stan2.isDepozit());
        stan1.setGrejanje(stan2.getGrejanje());
        stan1.setInternet(stan2.isInternet());
        stan1.setKablovska(stan2.isKablovska());
        stan1.setKlima(stan2.isKlima());
        stan1.setKvadratura(stan2.getKvadratura());
        stan1.setMapa(stan2.getMapa());
        stan1.setNacinPlacanja(stan2.getNacinPlacanja());
        stan1.setNamestenost(stan2.getNamestenost());
        stan1.setNaslov(stan2.getNaslov());
        stan1.setOpis(stan2.getOpis());
        stan1.setSprat(stan2.getSprat());
        stan1.setTelefon(stan2.isTelefon());
        stan1.setTerasa(stan2.isTerasa());
        stan1.setValidiran(false);
    }

}
