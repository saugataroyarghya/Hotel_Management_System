package com.example.hms;

public class Receptionist {
    Integer ID;
    String Name;
    String username;
    String password;

    public Receptionist(Integer ID, String name, String username, String password) {
        this.ID = ID;
        this.Name = name;
        this.username = username;
        this.password = password;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
