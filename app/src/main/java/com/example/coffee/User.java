package com.example.coffee;

public class User {
    int id;
    String name, pass, phone, image;
    int role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public User(int id, String name, String pass, String phone, String image, int role) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.phone = phone;
        this.image = image;
        this.role = role;
    }
}
