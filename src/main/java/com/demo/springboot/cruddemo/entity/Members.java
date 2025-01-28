package com.demo.springboot.cruddemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "members")
public class Members {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "pw")
    private String password;

    @Column(name = "active")
    private Integer active;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Members(String userId, String password, Integer active) {
        this.userId = userId;
        this.password = password;
        this.active = active;
    }

    public Members(String userId, String password) {
        this.userId = userId;
        this.password = password;
        this.active = 1;
    }

    public Members() {

    }

}
