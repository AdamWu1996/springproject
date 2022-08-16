package com.adam.springproject.repositories.entites;

import javax.persistence.*;

@Entity
@Table(name = "`user`")
public class User {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自動增加
    private Integer id;

    private String account;
    private String password;

    public User() {

    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
