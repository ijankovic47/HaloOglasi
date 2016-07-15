package ita.daoIMPL;

import ita.dao.Validate_dao;
import ita.domain.Stan;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Validate_daoIMPL implements Validate_dao {

    @Autowired
    SessionFactory sessionFactory;
    Transaction t = null;
    Query q = null;

    @Override
    public void validate(int id) {

        Session s = sessionFactory.getCurrentSession();
        t = s.beginTransaction();

        q = s.createQuery("from Stan where id='" + id + "'");

        Stan stan = (Stan) q.list().get(0);
        stan.setValidiran(true);

        s.update(stan);

        t.commit();
    }

}
