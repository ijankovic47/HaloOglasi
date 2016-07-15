package ita.daoIMPL;

import ita.dao.LogIn_dao;
import ita.domain.Adresa;
import ita.domain.Clan;
import ita.domain.Naselje;
import ita.domain.Opstina;
import ita.domain.Stan;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogIn_daoIMPL implements LogIn_dao {

    @Autowired
    SessionFactory sessionFactory;
    Transaction t = null;
    Query q = null;

    @Override
    public Clan logIn(String email, String password) {

        Session s = sessionFactory.getCurrentSession();
        t = s.beginTransaction();

        Clan clan = new Clan();

        q = s.createQuery("from Clan where email='" + email + "' and password='" + password + "'");
        if (q.list().size() > 0) {
            clan = (Clan) q.list().get(0);
        }
        t.commit();

        return clan;
    }
}
