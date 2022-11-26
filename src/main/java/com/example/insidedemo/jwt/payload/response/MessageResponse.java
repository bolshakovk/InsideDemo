package com.example.insidedemo.jwt.payload.response;

//ответ сообщения, что в нем хранится
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
