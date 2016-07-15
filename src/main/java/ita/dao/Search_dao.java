package ita.dao;

import ita.domain.Stan;
import java.util.List;

public interface Search_dao {
    
    public List<Stan> search(int cena, int kvadratura, int naseljeId, String brSoba);
    
    public List<Stan> adminSearch();
}
