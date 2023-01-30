package models;

import java.util.Objects;

public class Dean {
    private Long IdDean;
    private Long idMentor;
    private String Name;
    private String Surname;
    private String Gender;

    public Long getIdDean() {
        return IdDean;
    }

    public void setIdDean(Long idDean) {
        IdDean = idDean;
    }

    public Long getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(Long idMentor) {
        this.idMentor = idMentor;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dean dean = (Dean) o;
        return IdDean.equals(dean.IdDean) && idMentor.equals(dean.idMentor) && Name.equals(dean.Name) && Surname.equals(dean.Surname) && Gender.equals(dean.Gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdDean, idMentor, Name, Surname, Gender);
    }

    @Override
    public String toString() {
        return "Dean{" +
                "IdDean=" + IdDean +
                ", idMentor=" + idMentor +
                ", name='" + Name + '\'' +
                ", surname='" + Surname + '\'' +
                ", gender='" + Gender + '\'' +
                '}';
    }
}
