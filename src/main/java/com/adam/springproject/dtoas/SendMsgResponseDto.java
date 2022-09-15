package com.adam.springproject.dtoas;

public class SendMsgResponseDto {
    private String msg;

    public SendMsgResponseDto(String msg) {
        this.msg = msg;
    }

    public SendMsgResponseDto() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
