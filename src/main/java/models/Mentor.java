package models;

import java.util.Objects;

public class Mentor {
    private Long idMentor;
    private Long idUniversity;
    private String name;
    private String surname;
    private String gender;
    private int age;

    public Long getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(Long idMentor) {
        this.idMentor = idMentor;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mentor mentor = (Mentor) o;
        return age == mentor.age && idMentor.equals(mentor.idMentor) && idUniversity.equals(mentor.idUniversity) && name.equals(mentor.name) && surname.equals(mentor.surname) && gender.equals(mentor.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMentor, idUniversity, name, surname, gender, age);
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "idMentor=" + idMentor +
                ", idUniversity=" + idUniversity +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
