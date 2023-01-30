package models;

import java.util.Objects;

public class Staff {
    private Long idStaff;
    private Long idUniversity;
    private String Name;
    private String Surname;
    private int Age;

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

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Age == staff.Age && idStaff.equals(staff.idStaff) && idUniversity.equals(staff.idUniversity) && Name.equals(staff.Name) && Surname.equals(staff.Surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStaff, idUniversity, Name, Surname, Age);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "idStaff=" + idStaff +
                ", idUniversity=" + idUniversity +
                ", name='" + Name + '\'' +
                ", surname='" + Surname + '\'' +
                ", age=" + Age +
                '}';
    }
}
