package org.lgs.lviv.education.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CabinetUserEditDto {
    private int id;

    @NotBlank(message = "First name can`t be empty!")
    private String firstName;

    @NotBlank(message = "Last name can`t be empty!")
    private String lastName;

    @NotBlank(message = "Email can`t be empty!")
    private String email;

    @Min(value = 1, message = "Age can`t be less than 1!")
    @Max(value = 100, message = "Age can`t be more than 100!")
    @NotNull(message = "Age can`t be empty!")
    private Integer age;

    @NotBlank(message = "Gender can`t be empty!")
    private String gender;

    @NotBlank(message = "Country can`t be empty!")
    private String country;

    @NotBlank(message = "City can`t be empty!")
    private String city;

    @NotBlank(message = "Photo can`t be empty!")
    private String coverId;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public String getCoverId() {
        return coverId;
    }

    public void setCoverId(String coverId) {
        this.coverId = coverId;
    }
}
