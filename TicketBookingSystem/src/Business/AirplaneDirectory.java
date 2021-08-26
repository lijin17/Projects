/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import java.util.ArrayList;

/**
 *
 * @author Rushabh
 */
public class AirplaneDirectory {
    
    private ArrayList<Airplane> airplaneDirectory;
    
    public AirplaneDirectory() {
        airplaneDirectory = new ArrayList<Airplane>();
    }

    public ArrayList<Airplane> getairplaneDirectory() {
        return airplaneDirectory;
    }
    
    public Airplane addAirplane() {
        Airplane p = new Airplane();
        airplaneDirectory.add(p);
        return p;
    }
    
    public void removeAirplane(Airplane p) {
        airplaneDirectory.remove(p);
    }
    
    public ArrayList<Airplane> searchAirplane(String keyWord){
        ArrayList<Airplane> reList=new ArrayList<Airplane>();
        for(Airplane s : this.airplaneDirectory){
            if(s.getWhichFleet().equals(keyWord)){
                reList.add(s);
            }
        }
        return reList;
    }
    
    public Airplane WhichAirplane(String keyWord) {
        for(Airplane c : airplaneDirectory) {
            if(keyWord.equals(c.getPlaneName())) {
                return c;
            }
        }
        return null;
    }
}
