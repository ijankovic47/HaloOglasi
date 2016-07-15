package ita.daoIMPL;

import ita.dao.SignUp_dao;
import ita.domain.Clan;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SignUp_daoIMPL implements SignUp_dao {

    @Autowired
    SessionFactory sessionFactory;
    Transaction t = null;
    Query q = null;

    @Override
    public boolean signUp(Clan clan) {

        Session s = sessionFactory.getCurrentSession();
        t = s.beginTransaction();
        try {
            s.save(clan);
            t.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            t.rollback();
            return false;
        }
    }

}
