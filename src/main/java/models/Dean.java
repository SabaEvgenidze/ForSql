package models;

import java.util.Objects;

public class Dean {
    private Long IdDean;
    private Long idMentor;
    private String name;
    private String surname;
    private String gender;

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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dean dean = (Dean) o;
        return IdDean.equals(dean.IdDean) && idMentor.equals(dean.idMentor) && name.equals(dean.name) && surname.equals(dean.surname) && gender.equals(dean.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdDean, idMentor, name, surname, gender);
    }

    @Override
    public String toString() {
        return "Dean{" +
                "IdDean=" + IdDean +
                ", idMentor=" + idMentor +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
