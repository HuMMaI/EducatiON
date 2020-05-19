package org.lgs.lviv.education.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    private int age;

    private String gender;

    private String country;

    private String city;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @Column(name = "role")
    private Set<Roles> roles;

    @Column(name = "cover_id")
    private String coverId;

    private boolean isEmailVerify;
    private String verifyHashCode;

    private boolean isApply;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, String coverId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public String getCoverId() {
        return coverId;
    }

    public void setCoverId(String coverId) {
        this.coverId = coverId;
    }

    public boolean isEmailVerify() {
        return isEmailVerify;
    }

    public void setEmailVerify(boolean emailVerify) {
        isEmailVerify = emailVerify;
    }

    public String getVerifyHashCode() {
        return verifyHashCode;
    }

    public void setVerifyHashCode(String verifyHashCode) {
        this.verifyHashCode = verifyHashCode;
    }

    public boolean isApply() {
        return isApply;
    }

    public void setApply(boolean apply) {
        isApply = apply;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
