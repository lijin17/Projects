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
public class Fleet {
    private String fleetName;
    private long fleetNumber;
    private String whichAirliner;
    private FleetDirectory fleetDirectory;

    public Fleet() {
        fleetDirectory=new FleetDirectory();
    }

    public String getWhichAirliner() {
        return whichAirliner;
    }

    public void setWhichAirliner(String whichAirliner) {
        this.whichAirliner = whichAirliner;
    }

    public FleetDirectory getFleetDirectory() {
        return fleetDirectory;
    }

    public void setFleetDirectory(FleetDirectory fleetDirectory) {
        this.fleetDirectory = fleetDirectory;
    }
    
    

    public String getFleetName() {
        return fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }

    public long getFleetNumber() {
        return fleetNumber;
    }

    public void setFleetNumber(long fleetNumber) {
        this.fleetNumber = fleetNumber;
    }

   @Override
    public String toString() {
        return fleetName;
    }
}
