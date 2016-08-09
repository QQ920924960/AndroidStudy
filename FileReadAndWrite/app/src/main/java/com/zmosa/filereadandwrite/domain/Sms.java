package com.zmosa.filereadandwrite.domain;


/**
 * Created by xmc06 on 16/7/28.
 */
public class Sms {
    private String body;
    private String date;
    private String type;
    private String address;

    public Sms(String body, String date, String type, String address) {
        this.body = body;
        this.date = date;
        this.type = type;
        this.address = address;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
