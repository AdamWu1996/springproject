package com.adam.springproject.dtoas;

public class SignUpResponseDto {
    private int id;
    private String account;

    public SignUpResponseDto() {
    }

    public SignUpResponseDto(int id, String account) {
        this.id = id;
        this.account = account;
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
}
