package ita.serviceIMPL;

import ita.dao.SignUp_dao;
import ita.domain.Clan;
import ita.domain.Stan;
import ita.model.ClanM;
import ita.model.StanM;
import ita.service.SignUp_service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUp_serviceIMPL implements SignUp_service {

    @Autowired
    SignUp_dao signUp_dao;

    @Override
    public boolean signUp(ClanM clanM) {

        Clan clan = repackClan(clanM);

        return signUp_dao.signUp(clan);
    }

    private Clan repackClan(ClanM clanM) {

        Clan clan = new Clan();

        clan.setEmail(clanM.getEmail());
        clan.setPassword(clanM.getPassword());
        clan.setTelefon(clanM.getTelefon());
        clan.setUsername(clanM.getUsername());
        clan.setStanovi(new ArrayList<Stan>());
        clan.setRole(clanM.getRole());

        return clan;
    }
}
