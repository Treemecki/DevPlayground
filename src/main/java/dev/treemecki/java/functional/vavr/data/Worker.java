package dev.treemecki.java.functional.vavr.data;

import java.util.Objects;

public class Worker {

    private final String firstName;
    private final String lastName;
    private final WorkerProfession profession;

    public Worker(String firstName, String lastName, WorkerProfession profession) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public WorkerProfession getProfession() {
        return profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(firstName, worker.firstName) &&
                Objects.equals(lastName, worker.lastName) &&
                profession == worker.profession;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, profession);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profession=" + profession +
                '}';
    }

}
