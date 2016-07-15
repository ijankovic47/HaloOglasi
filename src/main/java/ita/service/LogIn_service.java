package ita.service;

import ita.domain.Stan;
import ita.model.ClanM;
import ita.model.StanM;
import java.util.List;

public interface LogIn_service {
    
    public ClanM logIn(String email, String password);
    
    public List<StanM> repackStanovi(List<Stan> stanovi);
}
