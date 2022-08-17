package com.example.api_recyclar_stringbuilder;

public class JsonModel {
    int userid, id;

    StringBuilder title, body;

    public JsonModel(int userid, int id, StringBuilder title, StringBuilder body) {
        this.userid = userid;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StringBuilder getTitle() {
        return title;
    }

    public void setTitle(StringBuilder title) {
        this.title = title;
    }

    public StringBuilder getBody() {
        return body;
    }

    public void setBody(StringBuilder body) {
        this.body = body;
    }
}