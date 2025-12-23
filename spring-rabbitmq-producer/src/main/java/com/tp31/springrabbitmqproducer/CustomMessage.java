package com.tp31.springrabbitmqproducer;

import java.util.Date;
import java.util.Objects;

public class CustomMessage {
    private String messageId;
    private String message;
    private Date messageDate;

    public CustomMessage() {
    }

    public CustomMessage(String messageId, String message, Date messageDate) {
        this.messageId = messageId;
        this.message = message;
        this.messageDate = messageDate;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    @Override
    public String toString() {
        return "CustomMessage{" +
                "messageId='" + messageId + '\'' +
                ", message='" + message + '\'' +
                ", messageDate=" + messageDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomMessage that = (CustomMessage) o;
        return Objects.equals(messageId, that.messageId) &&
                Objects.equals(message, that.message) &&
                Objects.equals(messageDate, that.messageDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, message, messageDate);
    }
}
