package com.cqsx.rgzn.smartagriculture.Untils;

public class User {
    private int photo;
    private String name;
    private String name1;

    public User(int photo, String name, String name1) {
        this.photo = photo;
        this.name = name;
        this.name1 = name1;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }
}
