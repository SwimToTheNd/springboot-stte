package com.stte.websocket.domain;

/**
 * create by BloodFly at 2018/12/19
 */
public class SocketResponse {
    private String responseMessage;

    public SocketResponse() {
    }

    public SocketResponse(String message) {
        this.responseMessage = message;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
