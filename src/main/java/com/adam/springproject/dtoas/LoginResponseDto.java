package com.adam.springproject.dtoas;

public class LoginResponseDto {
    private int id;
    private String account;

    private String msg;

    public LoginResponseDto() {
    }

    public LoginResponseDto(int id, String account, String msg) {
        this.id = id;
        this.account = account;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
