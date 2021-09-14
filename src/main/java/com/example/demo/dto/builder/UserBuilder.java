package com.example.demo.dto.builder;

import com.example.demo.dto.UserDTO;
import com.example.demo.models.User;

public class UserBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    public UserBuilder withUsuarioDto(UserDTO userDTO) {
        this.firstName = userDTO.getName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        return this;
    }

    public User build() {
        return new User(username, firstName, lastName, email, password);
    }
}
