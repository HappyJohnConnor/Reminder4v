package com.example.author.reminder4v.model;

import java.time.LocalDateTime;

/**
 * Created by author on 2017/09/24.
 */

public class ReminderItem {

    private String subject;
    private String body;
    private String id;
    private boolean hasRemind;
    private LocalDateTime dateTime;

    public ReminderItem(String subject, String body,String id, boolean hasRemind) {
        this.subject = subject;
        this.body = body;
        this.id = id;
        this.hasRemind=hasRemind;
    }

    public ReminderItem() {
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

    public void setHasRemind(boolean hasRemind) {
        this.hasRemind = hasRemind;
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

    public boolean isHasRemind() {
        return hasRemind;
    }
}
