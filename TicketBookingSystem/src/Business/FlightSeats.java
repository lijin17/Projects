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
public class FlightSeats {
    
   
    public FlightSeats() {
         
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
}
