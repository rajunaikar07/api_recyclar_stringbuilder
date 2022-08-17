package com.example.api_recyclar_stringbuilder;

public class JsonModel {

    StringBuilder id, name, mobile, dateInfo, password, email;

    public StringBuilder getId() {
        return id;
    }

    public void setId(StringBuilder id) {
        this.id = id;
    }

    public StringBuilder getName() {
        return name;
    }

    public void setName(StringBuilder name) {
        this.name = name;
    }

    public StringBuilder getMobile() {
        return mobile;
    }

    public void setMobile(StringBuilder mobile) {
        this.mobile = mobile;
    }

    public StringBuilder getDateInfo() {
        return dateInfo;
    }

    public void setDateInfo(StringBuilder dateInfo) {
        this.dateInfo = dateInfo;
    }

    public StringBuilder getPassword() {
        return password;
    }

    public void setPassword(StringBuilder password) {
        this.password = password;
    }

    public StringBuilder getEmail() {
        return email;
    }

    public void setEmail(StringBuilder email) {
        this.email = email;
    }

    public JsonModel(StringBuilder id, StringBuilder name,
                     StringBuilder mobile, StringBuilder dateInfo,
                     StringBuilder password, StringBuilder email) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.dateInfo = dateInfo;
        this.password = password;
        this.email = email;
    }
}

