package com.company.dto;

import com.company.entity.*;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phone;
    private String password;

    public UserDto() {
    }

    public UserDto(Integer id, String name, String surname, String address, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public UserDto(User u) {
        this.id = u.getId();
        this.name = u.getName();
        this.surname = u.getSurname();
        this.address = u.getAddress();
        this.phone = u.getPhone();
        this.email = u.getEmail();;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
