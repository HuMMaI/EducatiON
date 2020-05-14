package org.lgs.lviv.education.entities;

import javax.persistence.*;

@Entity
@Table(name = "statements")
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @Column(name = "average_grade_of_subjects")
    private double averageGradeOfSubjects;

    @Column(name = "average_grade_of_certificate")
    private double averageGradeOfCertificate;

    private double grade;

    private boolean isCredited;

    public Statement() {
    }

    public Statement(User user, Faculty faculty, double averageGradeOfSubjects, double averageGradeOfCertificate, double grade) {
        this.user = user;
        this.faculty = faculty;
        this.averageGradeOfSubjects = averageGradeOfSubjects;
        this.averageGradeOfCertificate = averageGradeOfCertificate;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public double getAverageGradeOfSubjects() {
        return averageGradeOfSubjects;
    }

    public void setAverageGradeOfSubjects(double averageGradeOfSubjects) {
        this.averageGradeOfSubjects = averageGradeOfSubjects;
    }

    public double getAverageGradeOfCertificate() {
        return averageGradeOfCertificate;
    }

    public void setAverageGradeOfCertificate(double averageGradeOfCertificate) {
        this.averageGradeOfCertificate = averageGradeOfCertificate;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean isCredited() {
        return isCredited;
    }

    public void setCredited(boolean credited) {
        isCredited = credited;
    }
}
