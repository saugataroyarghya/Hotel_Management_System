package com.example.hms;

import java.util.Date;

public class Booking {
    Integer room_id,guest_id;
    String name;
    Date checkin,checkout;

    public Booking(Integer room_id, Integer guest_id, String name, Date checkin, Date checkout) {
        this.room_id = room_id;
        this.guest_id = guest_id;
        this.name = name;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(Integer guest_id) {
        this.guest_id = guest_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }
}
