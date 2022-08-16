package com.adam.springproject.dtoas;

import com.adam.springproject.repositories.entites.User;

public class LoginResponseDto {
    private int id;
    private String email;

    private String name;
    private String gender;

    public LoginResponseDto() {
    }

    public LoginResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.gender = user.getGender();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}
