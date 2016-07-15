package ita.serviceIMPL;

import ita.dao.DeleteStan_dao;
import ita.service.DeleteStan_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStan_serviceIMPL implements DeleteStan_service {

    @Autowired
    DeleteStan_dao deleteStan_dao;

    @Override
    public void deleteStan(int id) {

        deleteStan_dao.deleteStan(id);
    }

}
