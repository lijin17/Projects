/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class CustomerDirectory {
    private ArrayList<Customer> CustomerDirect;
    
    public CustomerDirectory() {
        CustomerDirect = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomerDirectory() {
        return CustomerDirect;
    }
    
    public Customer addCustomer() {
        Customer s = new Customer();
        CustomerDirect.add(s);
        return s;
    }
    
    public void removeCustomer(Customer s) {
        CustomerDirect.remove(s);
    }
    
     public ArrayList<Customer> searchCustomer(String keyWord){
        ArrayList<Customer> reList=new ArrayList<Customer>();
        for(Customer s : this.CustomerDirect){
            if(s.getWhichFlight().equals(keyWord)){
                reList.add(s);
            }
        }
        return reList;
    }
     public Customer searchCustomerId(Long keyWord) {
        for(Customer c : CustomerDirect) {
            if(keyWord.equals(c.getIDNum())) {
                return c;
            }
        }
        return null;
    }
     
    
}
