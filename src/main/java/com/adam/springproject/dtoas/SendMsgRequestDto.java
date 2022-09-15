package com.adam.springproject.dtoas;

import javax.validation.constraints.Size;

public class SendMsgRequestDto {
    @Size(min = 1, max = 100)
    private String message;

    public SendMsgRequestDto() {
    }

    public SendMsgRequestDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
