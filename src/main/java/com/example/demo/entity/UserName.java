package com.example.demo.entity;

import java.io.Serializable;

public class UserName implements Serializable {
    private Integer id;
    private String name;

    public UserName(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserName() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
