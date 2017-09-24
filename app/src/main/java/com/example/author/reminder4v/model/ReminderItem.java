package com.example.author.reminder4v.model;

/**
 * Created by author on 2017/09/24.
 */

public class ReminderItem {

    private String subject;
    private String body;
    private int id;

    public ReminderItem(String title, String body, int id) {
        this.subject = title;
        this.body = body;
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public int getId() {
        return id;
    }
}
