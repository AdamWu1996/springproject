package com.adam.springproject.repositories.entites;

import com.adam.springproject.dtoas.SignUpRequestDto;

import javax.persistence.*;

@Entity
@Table(name = "`user`")
public class User {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自動增加
    private int id;
    @Column(length = 18)
    private String name;
    private Integer age;
    private String gender;
    @Column(unique = true)

    private String email;
    @Column(length = 20)
    private String password;

    public User() {
    }

    public User(SignUpRequestDto signUpRequestDto) {
        this.name = signUpRequestDto.getName();
        this.age = signUpRequestDto.getAge();
        this.gender = signUpRequestDto.getGender();
        this.email = signUpRequestDto.getEmail();
        this.password = signUpRequestDto.getPassword();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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
