package org.lgs.lviv.education.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDto {
    @NotBlank(message = "First name can`t be empty!")
    private String firstName;

    @NotBlank(message = "Last name can`t be empty!")
    private String lastName;

    @NotBlank(message = "Email can`t be empty!")
    private String email;

    @NotEmpty(message = "Roles can`t be empty!")
    private Set<String> roles;

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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        String[] rolesArray = roles.split(",");
        this.roles = roles.equals("") ? Collections.emptySet() : Arrays.stream(rolesArray)
                .map(String::valueOf)
                .collect(Collectors.toSet());
    }
}
