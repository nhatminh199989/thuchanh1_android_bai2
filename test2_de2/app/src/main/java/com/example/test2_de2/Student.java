package com.example.test2_de2;

import java.util.Date;

public class Student {
    int image;
    String id;
    String gender;
    String name;
    Date dob;

    public Student(int image, String id, String gender, String name, Date dob) {
        this.image = image;
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.dob = dob;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
