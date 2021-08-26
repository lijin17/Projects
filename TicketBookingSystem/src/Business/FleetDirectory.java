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
public class FleetDirectory {
    private ArrayList<Fleet> FleetDirectory;
    
    public FleetDirectory() {
        FleetDirectory = new ArrayList<Fleet>();
    }

    public ArrayList<Fleet> getFleetDirectory() {
        return FleetDirectory;
    }
    
    public Fleet addFleet() {
        Fleet s = new Fleet();
        FleetDirectory.add(s);
        return s;
    }
    
    public void removeFleet(Fleet s) {
        FleetDirectory.remove(s);
    }
    
    public ArrayList<Fleet> searchFleet(String keyWord){
        ArrayList<Fleet> reList=new ArrayList<Fleet>();
        for(Fleet s : this.FleetDirectory){
            if(s.getWhichAirliner().equals(keyWord)){
                reList.add(s);
            }
        }
        return reList;
    }
    
    public Fleet whichFleet(String keyWord) {
        for(Fleet c : FleetDirectory) {
            if(keyWord.equals(c.getFleetName())) {
                return c;
            }
        }
        return null;
    }
    
}
