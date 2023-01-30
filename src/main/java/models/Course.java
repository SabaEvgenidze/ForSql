package models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Course {
    private Long idCourse;
    private String Name;
    private int Course;

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getCourse() {
        return Course;
    }

    public void setCourse(int course) {
        this.Course = course;
    }

    public Course() {
    }

    public Course(Long idCourse, String name, int course) {
        this.idCourse = idCourse;
        this.Name = name;
        this.Course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course1 = (Course) o;
        return Course == course1.Course && idCourse.equals(course1.idCourse) && Name.equals(course1.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse, Name, Course);
    }

    @Override
    public String toString() {
        return "Course{" +
                "idCourse=" + idCourse +
                ", name='" + Name + '\'' +
                ", course=" + Course +
                '}';
    }
}
