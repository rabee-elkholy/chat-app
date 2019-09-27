package com.example.chatproject.forgetpassword;

public class Admin {
    private String name;
    private String type;

    public Admin (String name, String type) {
        this.name = name;
        this.type = type;
    }
    public String getName() {
        return this.name;
    }
    public String getType() {
        return this.type;
    }

}
