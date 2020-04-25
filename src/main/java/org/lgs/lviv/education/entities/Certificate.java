package org.lgs.lviv.education.entities;

import javax.persistence.*;

@Entity
@Table(name = "certificates")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int grade;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Certificate() {
    }

    public Certificate(String name, int grade, User user) {
        this.name = name;
        this.grade = grade;
        this.user = user;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
