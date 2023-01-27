package models;

import java.util.Objects;

public class Staff {
    private Long idStaff;
    private Long idUniversity;
    private String name;
    private String surname;
    private int age;

    public Long getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Long idStaff) {
        this.idStaff = idStaff;
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
        Staff staff = (Staff) o;
        return age == staff.age && idStaff.equals(staff.idStaff) && idUniversity.equals(staff.idUniversity) && name.equals(staff.name) && surname.equals(staff.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStaff, idUniversity, name, surname, age);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "idStaff=" + idStaff +
                ", idUniversity=" + idUniversity +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
