package models;

import java.util.Objects;

public class Owe {
    private Long idOwe;
    private Long idStudent;
    private int amountOfOwe;

    public Long getIdOwe() {
        return idOwe;
    }

    public void setIdOwe(Long idOwe) {
        this.idOwe = idOwe;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public int getAmountOfOwe() {
        return amountOfOwe;
    }

    public void setAmountOfOwe(int amountOfOwe) {
        this.amountOfOwe = amountOfOwe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owe owe = (Owe) o;
        return amountOfOwe == owe.amountOfOwe && idOwe.equals(owe.idOwe) && idStudent.equals(owe.idStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOwe, idStudent, amountOfOwe);
    }

    @Override
    public String toString() {
        return "Owe{" +
                "idOwe=" + idOwe +
                ", idStudent=" + idStudent +
                ", amountOfOwe=" + amountOfOwe +
                '}';
    }
}
