package com.example.zhandos.mad_lab_04_1;

import java.io.Serializable;

/**
 * Created by zhandos on 9/20/17.
 */

public class Email implements Serializable {

    private int id;
    private String sender;
    private String cc;
    private String date;
    private String subject;
    private String title;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Email(int id, String sender, String cc, String date, String subject, String title, String content) {
        this.id = id;
        this.sender = sender;
        this.cc = cc;
        this.date = date;
        this.subject = subject;
        this.title = title;
        this.content = content;
    }
}
