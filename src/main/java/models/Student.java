package models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Student {
    private Long idStudent;
    private Long idUniversity;
    private Long idFaculty;
    private String Name;
    private String Surname;
    private String Gender;
    private int Age;

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public Long getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(Long idUniversity) {
        this.idUniversity = idUniversity;
    }

    public Long getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(Long idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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

    public Student() {
    }

    public Student(Long idStudent, Long idUniversity, Long idFaculty, String name, String surname, String gender, int age) {
        this.idFaculty = idFaculty;
        this.idUniversity = idUniversity;
        this.idStudent = idStudent;
        this.Name = name;
        this.Surname = surname;
        this.Gender = gender;
        this.Age = age;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Age == student.Age && idStudent.equals(student.idStudent) && idUniversity.equals(student.idUniversity) && idFaculty.equals(student.idFaculty) && Name.equals(student.Name) && Surname.equals(student.Surname) && Gender.equals(student.Gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, idUniversity, idFaculty, Name, Surname, Gender, Age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", idUniversity=" + idUniversity +
                ", idFaculty=" + idFaculty +
                ", name='" + Name + '\'' +
                ", surname='" + Surname + '\'' +
                ", gender='" + Gender + '\'' +
                ", age=" + Age +
                '}';
    }
}
