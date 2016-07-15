package ita.daoIMPL;

import ita.dao.DeleteStan_dao;
import ita.domain.Slika;
import ita.domain.Stan;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteStan_daoIMPL implements DeleteStan_dao {

    @Autowired
    SessionFactory sessionFactory;
    Transaction t = null;
    Query q = null;

    @Override
    public void deleteStan(int id) {

        Session s = sessionFactory.getCurrentSession();
        t = s.beginTransaction();

        q = s.createQuery("from Stan where id='" + id + "'");

        Stan stan = (Stan) q.list().get(0);
        s.delete(stan);

        t.commit();
    }

}
