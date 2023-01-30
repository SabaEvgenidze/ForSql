package models;

import java.util.Objects;

public class University {
    private Long idUniversity;
    private String Name;
    private int Location;

    public Long getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(Long idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getLocation() {
        return Location;
    }

    public void setLocation(int location) {
        this.Location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Location == that.Location && idUniversity.equals(that.idUniversity) && Name.equals(that.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUniversity, Name, Location);
    }

    @Override
    public String toString() {
        return "University{" +
                "idUniversity=" + idUniversity +
                ", name='" + Name + '\'' +
                ", location=" + Location +
                '}';
    }
}
