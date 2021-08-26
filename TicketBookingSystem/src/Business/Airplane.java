/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

/**
 *
 * @author Rushabh
 */
public class Airplane {
    private String planeName;
    private String planeType;
    private int planeNum;
    private String whichFleet;
    private AirplaneDirectory AirplaneDirectory;

/*
    public Airplane() {
        count++;
        modelNumber = count;
    }
*/
    public Airplane() {
        AirplaneDirectory=new AirplaneDirectory();
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public String getWhichFleet() {
        return whichFleet;
    }

    public void setWhichFleet(String whichFleet) {
        this.whichFleet = whichFleet;
    }

    public AirplaneDirectory getAirplaneDirectory() {
        return AirplaneDirectory;
    }

    public void setAirplaneDirectory(AirplaneDirectory AirplaneDirectory) {
        this.AirplaneDirectory = AirplaneDirectory;
    }

    
    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public int getPlaneNum() {
        return planeNum;
    }

    public void setPlaneNum(int planeNum) {
        this.planeNum = planeNum;
    }
    
    
    @Override
    public String toString() {
        return planeName;
    }
    
}
