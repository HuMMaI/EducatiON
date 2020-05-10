package org.lgs.lviv.education.dtos;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FacultyAddDto {
    private String name;
    private Integer numberOfSeats;
    private Set<String> subjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Set<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        String[] subjectsArray = subjects.split(",");
        this.subjects = Arrays.stream(subjectsArray)
                .map(String::valueOf)
                .collect(Collectors.toSet());
    }
}
