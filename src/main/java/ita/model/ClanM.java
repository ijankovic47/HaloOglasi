package ita.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ClanM implements Serializable {

    @Pattern(regexp = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", message = "Email nije validan.")
    private String email;
    
    @Size(min = 5, max = 20, message = "Username mora imati izmedju 5 i 20 karaktera.")
    @Pattern(regexp = "^[a-zA-Z\\-]+$", message = "Username moze sadrzati samo slova i '-'.")
    private String username;
    
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password mora imati najmanje 8 karaktera, minimum jednu cifru i jedno slovo.")
    private String password;
    
    @Size(min = 7, max = 10, message = "Broj telefona mora sadrzati izmedju 7 i 10 cifara.")
    @Pattern(regexp = "^[0-9]+$", message = "Broj telefona moze sadrzati samo cifre.")
    private String telefon;
    
    private String role = "user";

    private List<StanM> stanovi = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public List<StanM> getStanovi() {
        return stanovi;
    }

    public void setStanovi(List<StanM> stanovi) {
        this.stanovi = stanovi;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
