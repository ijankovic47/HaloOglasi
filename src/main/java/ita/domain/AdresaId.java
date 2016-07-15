package ita.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class AdresaId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Naselje naselje;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Ulica ulica;

    public Naselje getNaselje() {
        return naselje;
    }

    public void setNaselje(Naselje naselje) {
        this.naselje = naselje;
    }

    @Override
    public int hashCode() {
        int result;
        result = (naselje != null ? naselje.hashCode() : 0);
        result = 31 * result + (ulica != null ? ulica.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdresaId that = (AdresaId) obj;

        if (naselje != null ? !naselje.equals(that.naselje) : that.naselje != null) {
            return false;
        }
        if (ulica != null ? !ulica.equals(that.ulica) : that.ulica != null) {
            return false;
        }
        return true;
    }

    public Ulica getUlica() {
        return ulica;
    }

    public void setUlica(Ulica ulica) {
        this.ulica = ulica;
    }
}
