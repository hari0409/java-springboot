package com.demo.springboot.cruddemo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @EmbeddedId
    private RoleId id;

    // Default constructor
    public Role() {
    }

    // Constructor
    public Role(String userId, String role) {
        this.id = new RoleId(userId, role);
    }

    // Getters and setters
    public RoleId getId() {
        return id;
    }

    public void setId(RoleId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                '}';
    }
}
