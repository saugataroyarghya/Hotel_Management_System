package com.example.hms;

import java.util.Date;

public class Guests {
    Integer ID;
    String name,username,password,address,city,country,phone,job_title,company,credit_card_no,credit_card_type;
    Date date_of_birth, checking_in, checking_out;

    public Guests(Integer ID, String name, String username, String password, String address, String city, String country, String phone, String job_title, String company, String credit_card_no, String credit_card_type, Date date_of_birth, Date checking_in, Date checking_out) {
        this.ID = ID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.job_title = job_title;
        this.company = company;
        this.credit_card_no = credit_card_no;
        this.credit_card_type = credit_card_type;
        this.date_of_birth = date_of_birth;
        this.checking_in = checking_in;
        this.checking_out = checking_out;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCredit_card_no() {
        return credit_card_no;
    }

    public void setCredit_card_no(String credit_card_no) {
        this.credit_card_no = credit_card_no;
    }

    public String getCredit_card_type() {
        return credit_card_type;
    }

    public void setCredit_card_type(String credit_card_type) {
        this.credit_card_type = credit_card_type;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getChecking_in() {
        return checking_in;
    }

    public void setChecking_in(Date checking_in) {
        this.checking_in = checking_in;
    }

    public Date getChecking_out() {
        return checking_out;
    }

    public void setChecking_out(Date checking_out) {
        this.checking_out = checking_out;
    }
}
