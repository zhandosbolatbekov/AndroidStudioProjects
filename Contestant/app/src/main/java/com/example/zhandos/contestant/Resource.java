package com.example.zhandos.contestant;

/**
 * Created by zhandos on 11/30/17.
 */

public class Resource {

    private int id;
    private String name;

    public Resource(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
