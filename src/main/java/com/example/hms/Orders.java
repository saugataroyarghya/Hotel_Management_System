package com.example.hms;

public class Orders {
    Integer order_id;
    Integer room_id;
    String comment;
    String status;

    public Orders(Integer order_id, Integer room_id, String comment, String status) {
        this.order_id = order_id;
        this.room_id = room_id;
        this.comment = comment;
        this.status = status;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
