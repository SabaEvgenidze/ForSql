package models;

import java.util.Objects;

public class University {
    private Long idUniversity;
    private String name;
    private int location;

    public Long getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(Long idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return location == that.location && idUniversity.equals(that.idUniversity) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUniversity, name, location);
    }

    @Override
    public String toString() {
        return "University{" +
                "idUniversity=" + idUniversity +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
