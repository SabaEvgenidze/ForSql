package models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Mentor {
    private Long idMentor;
    private Long idUniversity;
    private String Name;
    private String Surname;
    private String Gender;
    private int Age;

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

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public Mentor(){}
    public Mentor (Long idMentor, Long idUniversity, String name, String surname, String gender, int age){
        this.idMentor=idMentor;
        this.idUniversity=idUniversity;
        this.Name=name;
        this.Surname=surname;
        this.Gender=gender;
        this.Age=age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mentor mentor = (Mentor) o;
        return Age == mentor.Age && idMentor.equals(mentor.idMentor) && idUniversity.equals(mentor.idUniversity) && Name.equals(mentor.Name) && Surname.equals(mentor.Surname) && Gender.equals(mentor.Gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMentor, idUniversity, Name, Surname, Gender, Age);
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "idMentor=" + idMentor +
                ", idUniversity=" + idUniversity +
                ", name='" + Name + '\'' +
                ", surname='" + Surname + '\'' +
                ", gender='" + Gender + '\'' +
                ", age=" + Age +
                '}';
    }
}
