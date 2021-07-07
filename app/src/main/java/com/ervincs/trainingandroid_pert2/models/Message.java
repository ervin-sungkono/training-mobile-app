package com.ervincs.trainingandroid_pert2.models;

public class Message {
    private String name, message;
    private int thumbnail;

    public Message(String name, String message, int thumbnail) {
        this.name = name;
        this.message = message;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
