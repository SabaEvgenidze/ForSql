package models;

import java.util.Objects;

public class Student {
    private Long idStudent;
    private Long idUniversity;
    private Long idFaculty;
    private String name;
    private String surname;
    private String gender;
    private int age;

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
        Student student = (Student) o;
        return age == student.age && idStudent.equals(student.idStudent) && idUniversity.equals(student.idUniversity) && idFaculty.equals(student.idFaculty) && name.equals(student.name) && surname.equals(student.surname) && gender.equals(student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, idUniversity, idFaculty, name, surname, gender, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", idUniversity=" + idUniversity +
                ", idFaculty=" + idFaculty +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
