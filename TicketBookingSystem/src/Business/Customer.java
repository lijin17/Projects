/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author lenovo
 */
public class Customer {
    private String name;
    private long IDNum;
    private int age;
    private String whichFlight;
    private CustomerDirectory customerDirectory;

    public Customer() {
        customerDirectory=new CustomerDirectory();
    }

    public String getWhichFlight() {
        return whichFlight;
    }

    public void setWhichFlight(String whichFlight) {
        this.whichFlight = whichFlight;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIDNum() {
        return IDNum;
    }

    public void setIDNum(long IDNum) {
        this.IDNum = IDNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
@Override
    public String toString() {
        return name;
    }
    
}
