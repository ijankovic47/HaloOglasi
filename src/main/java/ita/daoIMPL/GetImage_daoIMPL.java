package ita.daoIMPL;

import ita.dao.GetImage_dao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GetImage_daoIMPL implements GetImage_dao {

    @Autowired
    public static SessionFactory sessionFactory;

    public GetImage_daoIMPL(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    public GetImage_daoIMPL() {
    }
}
