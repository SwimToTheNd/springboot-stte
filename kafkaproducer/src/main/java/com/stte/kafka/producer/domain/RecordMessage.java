package com.stte.kafka.producer.domain;

import java.util.Date;

/**
 * create by BloodFly at 2018/12/31
 */
public class RecordMessage {
    private Long id;
    private String message;
    private Date sendTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "RecordMessage{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
