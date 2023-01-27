package models;

import java.util.Objects;

public class StudentHasMentor {
    private Long idStudent;
    private Long idMentor;

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public Long getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(Long idMentor) {
        this.idMentor = idMentor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentHasMentor that = (StudentHasMentor) o;
        return idStudent.equals(that.idStudent) && idMentor.equals(that.idMentor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, idMentor);
    }

    @Override
    public String toString() {
        return "StudentHasMentor{" +
                "idStudent=" + idStudent +
                ", idMentor=" + idMentor +
                '}';
    }
}
