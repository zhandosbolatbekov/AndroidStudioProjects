package com.example.zhandos.mad_lab_02;

/**
 * Created by zhandos on 9/12/17.
 */

public class Person {

    private String imageUrl;
    private String lastName;
    private String firstName;
    private String mobile;
    private String email1;
    private String email2;
    private String address;

    public Person(String imageUrl, String lastName, String firstName, String mobile, String email1, String email2, String address) {
        this.imageUrl = imageUrl;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mobile = mobile;
        this.email1 = email1;
        this.email2 = email2;
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
