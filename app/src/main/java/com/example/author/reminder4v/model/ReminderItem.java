package com.example.author.reminder4v.model;

/**
 * Created by author on 2017/09/24.
 */

public class ReminderItem {

    private String subject;
    private String body;
    private String id;

    public ReminderItem(String subject, String body,String id) {
        this.subject = subject;
        this.body = body;
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getId() {
        return id;
    }
}
