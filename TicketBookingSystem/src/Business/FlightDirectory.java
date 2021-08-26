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
public class FlightDirectory {
    private ArrayList<Flight> FlightDirectory;
    
    public FlightDirectory() {
        FlightDirectory = new ArrayList<Flight>();
        
    }

    public ArrayList<Flight> getFlightDirectory() {
        return FlightDirectory;
    }

    public void setFlightDirectory(ArrayList<Flight> FlightDirectory) {
        this.FlightDirectory = FlightDirectory;
    }

    public ArrayList<Flight> FlightDirectory() {
        return FlightDirectory;
    }
    
    public Flight addFlight() {
        Flight s = new Flight();
        FlightDirectory.add(s);
        return s;
    }
    
    public void removeFlight(Flight s) {
        FlightDirectory.remove(s);
    }
    
    
    
    public ArrayList<Flight> searchFlight(String keyWord){
        ArrayList<Flight> reList=new ArrayList<Flight>();
        for(Flight s : this.FlightDirectory){
            if(s.getWhichPlane().equals(keyWord)){
                reList.add(s);
            }
        }
        return reList;
    }
    
    public ArrayList<Flight> searchFlightList(String name,String time,String fromLocation,String toLocation){
        ArrayList<Flight> reList=new ArrayList<Flight>();
        if(name!=""&&time==""&&fromLocation!=""&&toLocation!=""){
            for(Flight s : this.FlightDirectory){
            if(s.getFromLocation().equalsIgnoreCase(fromLocation)&&s.getToLocation().equalsIgnoreCase(toLocation)&&s.getName().equalsIgnoreCase(name)){
                reList.add(s);
            }
        }
        }else if(name==""&&time!=""&&fromLocation!=""&&toLocation!=""){
            for(Flight s : this.FlightDirectory){
            if(s.getTime().equals(time)&&s.getFromLocation().equalsIgnoreCase(fromLocation)&&s.getToLocation().equalsIgnoreCase(toLocation)){
                reList.add(s);
            }
        }
        }else if(name!=""&&time!=""&&fromLocation!=""&&toLocation!=""){
            for(Flight s : this.FlightDirectory){
            if(s.getName().equals(name)&&s.getTime().equals(time)&&s.getFromLocation().equalsIgnoreCase(fromLocation)&&s.getToLocation().equalsIgnoreCase(toLocation)){
                reList.add(s);
            }
        }
        }else if(name==""&&time==""&&fromLocation!=""&&toLocation!=""){
            for(Flight s : this.FlightDirectory){
            if(s.getFromLocation().equalsIgnoreCase(fromLocation)&&s.getToLocation().equalsIgnoreCase(toLocation)){
                reList.add(s);
            }
        }
        
    }
        return reList;
    }
    
    public Flight whichFlight(String keyWord) {
        for(Flight c : FlightDirectory) {
            if(keyWord.equals(c.getName())) {
                return c;
            }
        }
        return null;
    }
  
}
