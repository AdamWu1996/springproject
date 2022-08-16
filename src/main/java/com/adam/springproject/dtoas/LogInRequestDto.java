package com.adam.springproject.dtoas;

public class LogInRequestDto {
    private String email;
    private String password;

    public LogInRequestDto() {
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
