package models;

import java.util.Objects;

public class Course {
    private Long idCourse;
    private String name;
    private int course;

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course1 = (Course) o;
        return course == course1.course && idCourse.equals(course1.idCourse) && name.equals(course1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse, name, course);
    }

    @Override
    public String toString() {
        return "Course{" +
                "idCourse=" + idCourse +
                ", name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
