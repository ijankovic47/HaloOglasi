package ita.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
@AssociationOverrides({
    @AssociationOverride(name = "pk.naselje",
            joinColumns = @JoinColumn(name = "naseljeId")),
    @AssociationOverride(name = "pk.ulica",
            joinColumns = @JoinColumn(name = "ulicaId"))})
public class Adresa {

    @EmbeddedId
    private AdresaId pk = new AdresaId();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "adresa")
    private List<Stan> stanovi = new ArrayList<>();

    public AdresaId getPk() {
        return pk;
    }

    public void setPk(AdresaId pk) {
        this.pk = pk;
    }

    @Transient
    public Naselje getNaselje() {
        return getPk().getNaselje();
    }

    public void setNaselje(Naselje naselje) {
        getPk().setNaselje(naselje);
    }

    @Transient
    public Ulica getUlica() {
        return getPk().getUlica();
    }

    public void setUlica(Ulica ulica) {
        getPk().setUlica(ulica);
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Adresa that = (Adresa) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null) {
            return false;
        }

        return true;
    }

    public List<Stan> getStanovi() {
        return stanovi;
    }

    public void setStanovi(List<Stan> stanovi) {
        this.stanovi = stanovi;
    }

    public String toString() {
        return "Opstina: " + pk.getNaselje().getOpstina() + ", naselje: " + pk.getNaselje() + ", ulica: " + pk.getUlica();
    }
}
