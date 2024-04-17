package com.myapp.EcoRide.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User {

    @Id
    private String zNumber;
    private String name;
    private String email;
    private String password;
    private String phone;
    @OneToOne(mappedBy = "user")
    private Bike bike;

    public String getzNumber() {
        return zNumber;
    }
    public void setzNumber(String zNumber) {
        this.zNumber = zNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
