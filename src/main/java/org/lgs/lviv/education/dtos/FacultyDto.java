package org.lgs.lviv.education.dtos;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FacultyDto {
    @NotBlank(message = "Faculty name can`t be empty!")
    private String name;

    @NotNull(message = "Number of seats can`t be empty!")
    private Integer numberOfSeats;

    @NotEmpty(message = "Subjects can`t be empty!")
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
        this.subjects = subjects.equals("") ? Collections.emptySet() : Arrays.stream(subjectsArray)
                .map(String::valueOf)
                .collect(Collectors.toSet());
    }
}
