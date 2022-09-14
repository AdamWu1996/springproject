package com.adam.springproject.dtoas;

import com.adam.springproject.repositories.entites.User;
import com.adam.springproject.services.EnumNamePattern;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

//Data transfer object 數據傳輸物件
public class SignUpRequestDto {
    @Size(min = 4, max = 18)
    private String name;

    private Integer age;
    @EnumNamePattern(regexp = "male|female")
    private User.Gender gender;

    @Email(message = "email format error")
    private String email;
    @Size(min = 10, max = 20)
    private String password;

    public SignUpRequestDto() {
    }

    public SignUpRequestDto(String name, Integer age, User.Gender gender, String email, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User.Gender getGender() {
        return gender;
    }

    public void setGender(User.Gender gender) {
        this.gender = gender;
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
}
