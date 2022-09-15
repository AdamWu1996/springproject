package com.adam.springproject.dtoas;

import com.adam.springproject.repositories.entites.User;

import javax.persistence.Column;

public class SignUpResponseDto {
    private int id;
    private String email;
    private String name;
    private User.Gender gender;
    private String message;
    public SignUpResponseDto() {
    }

    public SignUpResponseDto(int id, User user, String message) {
        this.id = id;
        this.email = user.getEmail();
        this.name = user.getName();
        this.gender = user.getGender();
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User.Gender getGender() {
        return gender;
    }

    public void setGender(User.Gender gender) {
        this.gender = gender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
