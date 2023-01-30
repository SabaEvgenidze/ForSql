package models;

import java.util.Objects;

public class Owe {
    private Long idOwe;
    private Long idStudent;
    private int AmountOfOwe;

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
        return AmountOfOwe;
    }

    public void setAmountOfOwe(int amountOfOwe) {
        this.AmountOfOwe = amountOfOwe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owe owe = (Owe) o;
        return AmountOfOwe == owe.AmountOfOwe && idOwe.equals(owe.idOwe) && idStudent.equals(owe.idStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOwe, idStudent, AmountOfOwe);
    }

    @Override
    public String toString() {
        return "Owe{" +
                "idOwe=" + idOwe +
                ", idStudent=" + idStudent +
                ", amountOfOwe=" + AmountOfOwe +
                '}';
    }
}
