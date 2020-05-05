package org.lgs.lviv.education.dtos;

import javax.validation.constraints.NotBlank;

public class UserRegistrationDto {
    @NotBlank(message = "First name can`t be empty!")
    private String firstName;

    @NotBlank(message = "Last name can`t be empty!")
    private String lastName;

    @NotBlank(message = "Email name can`t be empty!")
    private String email;

    @NotBlank(message = "Password name can`t be empty!")
    private String password;

    @NotBlank(message = "Password confirmation can`t be empty!")
    private String passwordConfirmation;

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

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
