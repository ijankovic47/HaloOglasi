package ita.serviceIMPL;

import ita.dao.Search_dao;
import ita.domain.Stan;
import ita.model.StanM;
import ita.service.LogIn_service;
import ita.service.Search_service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Search_serviceIMPL implements Search_service {

    @Autowired
    Search_dao search_dao;

    @Autowired
    LogIn_service logIn_service;

    @Override
    public List<StanM> search(int cena, int kvadratura, int naseljeId, String brSoba) {

        List<Stan> stanovi = search_dao.search(cena, kvadratura, naseljeId, brSoba);

        List<StanM> stanoviM = new ArrayList<>();

        stanoviM = logIn_service.repackStanovi(stanovi);

        return stanoviM;
    }

    @Override
    public List<StanM> adminSearch() {

        List<Stan> stanovi = search_dao.adminSearch();

        List<StanM> stanoviM = new ArrayList<>();

        stanoviM = logIn_service.repackStanovi(stanovi);

        return stanoviM;

    }
}
