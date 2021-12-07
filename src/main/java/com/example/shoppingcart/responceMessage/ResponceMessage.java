package com.example.shoppingcart.responceMessage;

public class ResponceMessage
{
    private String message;

    public ResponceMessage(String message) {
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
