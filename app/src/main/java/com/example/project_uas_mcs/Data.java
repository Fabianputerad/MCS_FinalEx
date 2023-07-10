package com.example.project_uas_mcs;

public class Data {
    private String UserId;
    private String Id;
    private String title;
    private  String body;

    public Data(){}
    public Data(String userId, String id, String title, String body) {
        this.UserId = userId;
        this.Id = id;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
