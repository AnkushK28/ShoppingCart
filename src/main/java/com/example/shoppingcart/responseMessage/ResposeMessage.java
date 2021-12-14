package com.example.shoppingcart.responseMessage;

public class ResposeMessage
{
    private String message;

    public ResposeMessage(String message) {
    }

    public void ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
