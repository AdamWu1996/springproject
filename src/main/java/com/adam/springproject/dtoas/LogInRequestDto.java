package com.adam.springproject.dtoas;

public class LogInRequestDto {
    private String account;
    private String password;

    public LogInRequestDto() {
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
