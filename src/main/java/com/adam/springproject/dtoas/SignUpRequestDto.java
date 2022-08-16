package com.adam.springproject.dtoas;

//Data transfer object 數據傳輸物件
public class SignUpRequestDto {
    private String account;
    private String password;

    public SignUpRequestDto() {
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
