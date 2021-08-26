/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.pojo;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author lijin
 */
public class Elder implements Serializable{

    private int id;
    private String name;
    private String phoneNum;
    private String address;
    private String password;
    private String gender;
    private String birthday;
    private Bed bed;
    private Set<BodyStatus> bodystatus;

    public Set<BodyStatus> getBodystatus() {
        return bodystatus;
    }

    public void setBodystatus(Set<BodyStatus> bodystatus) {
        this.bodystatus = bodystatus;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    
    

}
