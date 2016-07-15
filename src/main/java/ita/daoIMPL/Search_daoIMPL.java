package ita.daoIMPL;

import ita.dao.Search_dao;
import ita.domain.Stan;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Search_daoIMPL implements Search_dao {

    @Autowired
    SessionFactory sessionFactory;
    Transaction t = null;
    Query q = null;

    @Override
    public List<Stan> search(int cena, int kvadratura, int naseljeId, String brSoba) {

        Session s = sessionFactory.getCurrentSession();
        t = s.beginTransaction();

        q = s.createQuery("from Stan where cena<='" + (cena == 0 ? 500 : cena) + "' and kvadratura>='" + kvadratura + "' "
                + (brSoba.equals("0") ? "" : "and brojSoba=" + brSoba + " ") + (naseljeId == 0 ? "" : "and adresa_naseljeId='" + naseljeId + "'") + " and validiran=" + true);

        List<Stan> stanovi = (List<Stan>) q.list();
        t.commit();

        return stanovi;
    }

    @Override
    public List<Stan> adminSearch() {

        Session s = sessionFactory.getCurrentSession();
        t = s.beginTransaction();

        q = s.createQuery("from Stan");

        List<Stan> stanovi = (List<Stan>) q.list();
        t.commit();

        return stanovi;
    }

}
