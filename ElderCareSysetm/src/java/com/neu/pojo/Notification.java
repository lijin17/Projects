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
public class Notification implements Serializable {
    private int id;
    private String content;
    private String sender;
    private String receiver;
    private String t;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

   

    
    
    
}
