package com.example.hms;

public class Rooms {
    Integer ID;
    String Type;
    String Telephone;
    String Television;
    String Exclusive_View;

    public Rooms(Integer ID, String type, String telephone, String television, String exclusive_View) {
        this.ID = ID;
        this.Type = type;
        this.Telephone = telephone;
        this.Television = television;
        this.Exclusive_View = exclusive_View;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getTelevision() {
        return Television;
    }

    public void setTelevision(String television) {
        Television = television;
    }

    public String getExclusive_View() {
        return Exclusive_View;
    }

    public void setExclusive_View(String exclusive_View) {
        Exclusive_View = exclusive_View;
    }
}
