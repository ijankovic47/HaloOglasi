package ita.serviceIMPL;

import ita.dao.Validate_dao;
import ita.service.Validate_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Validate_serviceIMPL implements Validate_service {

    @Autowired
    Validate_dao validate_dao;

    @Override
    public void validate(int id) {

        validate_dao.validate(id);

    }

}
