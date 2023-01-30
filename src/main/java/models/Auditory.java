package models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Auditory {
    private Long idAuditory;
    private Long idUniversity;
    private int Capacity;

    public Long getIdAuditory() {
        return idAuditory;
    }

    public void setIdAuditory(Long idAuditory) {
        this.idAuditory = idAuditory;
    }

    public Long getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(Long idUniversity) {
        this.idUniversity = idUniversity;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        this.Capacity = capacity;
    }

    public Auditory() {
    }

    public Auditory(Long idUniversity, Long idAuditory, int capacity) {
        this.idAuditory = idAuditory;
        this.idUniversity = idUniversity;
        this.Capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auditory auditory = (Auditory) o;
        return Capacity == auditory.Capacity && idAuditory.equals(auditory.idAuditory) && idUniversity.equals(auditory.idUniversity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAuditory, idUniversity, Capacity);
    }

    @Override
    public String toString() {
        return "Auditory{" +
                "idAuditory=" + idAuditory +
                ", idUniversity=" + idUniversity +
                ", capacity=" + Capacity +
                '}';
    }
}
