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
public class Flight {
    private String name;
    private String time;
    private String fromLocation;
    private String toLocation;
    private String whichPlane;
    private FlightDirectory FlightDirectory;
    private FlightSeats flightSeats;
    private int[][] arr;

    public Flight() {
    FlightDirectory=new FlightDirectory();
    flightSeats=new FlightSeats();
    int index=0;
    int [][] arr=new int [150][3];
    for(int i=1; i<=25;i++){
        for(int j=1; j<=6; j++){
            arr[index][0]=i;
            arr[index][1]=j;
            arr[index][2]=1;
            index++;
        }
      }
    this.arr=arr;
    }

    public int[][] getSeats(){
        return arr;
    }
    
    public boolean isAvailable(int a,int b,int[][] arr){
        for(int i=0;i<=150;i++){
            if(a==arr[i][0]&&b==arr[i][1]&&arr[i][2]==1){
                return true;//not booked
            }else if(a==arr[i][0]&&b==arr[i][1]&&arr[i][2]==0){
                return false;//booked
            }
        }
        return false;
    }
    public void book(int a, int b, int[][] arr){
        for(int i=0;i<150;i++){
            if(a==arr[i][0]&&b==arr[i][1]){
                arr[i][2]=0;
            }
        }
        
    }
    public FlightSeats getFlightSeats() {
        return flightSeats;
    }

    public void setFlightSeats(FlightSeats flightSeats) {
        this.flightSeats = flightSeats;
    }

    public FlightDirectory getFlightDirectory() {
        return FlightDirectory;
    }

    public void setFlightDirectory(FlightDirectory FlightDirectory) {
        this.FlightDirectory = FlightDirectory;
    }
    
    

    public String getWhichPlane() {
        return whichPlane;
    }

    public void setWhichPlane(String whichPlane) {
        this.whichPlane = whichPlane;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }
     @Override
    public String toString() {
        return name;
    }
    
}
