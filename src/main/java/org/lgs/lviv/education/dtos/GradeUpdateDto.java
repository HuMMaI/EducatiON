package org.lgs.lviv.education.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class GradeUpdateDto {
    private int id;

    @Min(value = 0)
    @Max(value = 100)
    private int grade;

    private String gradeType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getGradeType() {
        return gradeType;
    }

    public void setGradeType(String gradeType) {
        this.gradeType = gradeType;
    }
}
