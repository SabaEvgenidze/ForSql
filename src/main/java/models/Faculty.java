package models;

import java.util.Objects;

public class Faculty {
    private Long idFaculty;
    private Long idCourse;
    private Long idDean;
    private String name;

    public Long getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(Long idFaculty) {
        this.idFaculty = idFaculty;
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public Long getIdDean() {
        return idDean;
    }

    public void setIdDean(Long idDean) {
        this.idDean = idDean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return idFaculty.equals(faculty.idFaculty) && idCourse.equals(faculty.idCourse) && idDean.equals(faculty.idDean) && name.equals(faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFaculty, idCourse, idDean, name);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "idFaculty=" + idFaculty +
                ", idCourse=" + idCourse +
                ", idDean=" + idDean +
                ", name='" + name + '\'' +
                '}';
    }
}
