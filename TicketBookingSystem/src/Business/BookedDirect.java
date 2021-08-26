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
public class BookedDirect {
    private ArrayList<Booked> BookedDirect;
    public BookedDirect() {
        BookedDirect = new ArrayList<Booked>();
        
    }

    public ArrayList<Booked> getBookedDirect() {
        return BookedDirect;
    }

    public void setBookedDirect(ArrayList<Booked> BookedDirect) {
        this.BookedDirect = BookedDirect;
    }

    public ArrayList<Booked> BookedDirect() {
        return BookedDirect;
    }
    
    public Booked addBooked() {
        Booked s = new Booked();
        BookedDirect.add(s);
        return s;
    }
    
    public void removeBooked(Booked s) {
        BookedDirect.remove(s);
    }
    public ArrayList<Booked> searchBooked(String keyWord){
        ArrayList<Booked> reList=new ArrayList<Booked>();
        for(Booked s : this.BookedDirect){
            if(s.getWhichflight().equals(keyWord)){
                reList.add(s);
            }
        }
        return reList;
    }
    
    
   
}
