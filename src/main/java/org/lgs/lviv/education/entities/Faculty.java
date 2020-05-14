package org.lgs.lviv.education.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = FacultySubjects.class, fetch = FetchType.EAGER)
    @Column(name = "subject")
    private Set<FacultySubjects> subjects;

    private String specialization;

    public Faculty() {
    }

    public Faculty(String name, int numberOfSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Set<FacultySubjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<FacultySubjects> subjects) {
        this.subjects = subjects;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
