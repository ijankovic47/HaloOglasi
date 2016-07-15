package ita.service;

import ita.model.StanM;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface Search_service {
    
    public List<StanM> search(int cena,int kvadratura,int naseljeId,String brSoba); 
    
    public List<StanM> adminSearch();
}
