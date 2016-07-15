package ita.daoIMPL;

import ita.domain.Adresa;
import ita.domain.AdresaId;
import ita.domain.Clan;
import ita.domain.Naselje;
import ita.domain.Opstina;
import ita.domain.Stan;
import ita.domain.Ulica;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import ita.dao.SetUp_dao;

@Repository
public class SetUp_daoIMPL implements SetUp_dao {

    @Autowired
    SessionFactory sessionFactory;
    Transaction t = null;
    Query q = null;

    @Override
    public List<Opstina> setUp() {
        Session s = getSession();
        t = s.beginTransaction();
        q = s.createQuery("from Opstina");
        List<Opstina> opstine = q.list();
        t.commit();
        return opstine;
    }

    private Session getSession() {
        Session s = sessionFactory.getCurrentSession();
        return s;
    }
}
