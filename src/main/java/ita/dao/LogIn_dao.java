package ita.dao;

import ita.domain.Clan;

public interface LogIn_dao {
    
    public Clan logIn(String email,String password);
}
