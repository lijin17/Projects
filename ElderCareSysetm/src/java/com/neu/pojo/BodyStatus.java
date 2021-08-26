/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.pojo;

import java.io.Serializable;

/**
 *
 * @author lijin
 */
public class BodyStatus implements Serializable{
    private int id;
    private String HR;//heart rate(60-100)
    private String SP;//systolic pressure(148)
    private String DP;//diastolic pressure(86)
    private String SPO2;//oxygen saturation(90+)
    private String TE;//temprature(about 37)
    private String RE;//respiration(16-20/minutes)
    private Elder elder;
    private String T;

    public String getT() {
        return T;
    }

    public void setT(String T) {
        this.T = T;
    }
    
    

    public Elder getElder() {
        return elder;
    }

    public void setElder(Elder elder) {
        this.elder = elder;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHR() {
        return HR;
    }

    public void setHR(String HR) {
        this.HR = HR;
    }

    public String getSP() {
        return SP;
    }

    public void setSP(String SP) {
        this.SP = SP;
    }

    public String getDP() {
        return DP;
    }

    public void setDP(String DP) {
        this.DP = DP;
    }

    public String getSPO2() {
        return SPO2;
    }

    public void setSPO2(String SPO2) {
        this.SPO2 = SPO2;
    }

    public String getTE() {
        return TE;
    }

    public void setTE(String TE) {
        this.TE = TE;
    }

    public String getRE() {
        return RE;
    }

    public void setRE(String RE) {
        this.RE = RE;
    }
    
    
}
