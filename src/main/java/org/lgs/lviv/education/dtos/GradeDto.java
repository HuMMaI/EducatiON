package org.lgs.lviv.education.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class GradeDto {
    @NotBlank(message = "Subject name can`t be empty!")
    private String name;

    @Min(value = 0, message = "Grade can`t be less than 0!")
    @Max(value = 100, message = "Grade can`t be more than 100!")
    @NotNull(message = "Subject grade can`t be empty!")
    private Integer grade;

    private String gradeType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getGradeType() {
        return gradeType;
    }

    public void setGradeType(String gradeType) {
        this.gradeType = gradeType;
    }
}
