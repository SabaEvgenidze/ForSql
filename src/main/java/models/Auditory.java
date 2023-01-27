package models;

import java.util.Objects;

public class Auditory {
    private Long idAuditory;
    private Long idUniversity;
    private int capacity;

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
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auditory auditory = (Auditory) o;
        return capacity == auditory.capacity && idAuditory.equals(auditory.idAuditory) && idUniversity.equals(auditory.idUniversity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAuditory, idUniversity, capacity);
    }

    @Override
    public String toString() {
        return "Auditory{" +
                "idAuditory=" + idAuditory +
                ", idUniversity=" + idUniversity +
                ", capacity=" + capacity +
                '}';
    }
}
