/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

/**
 *
 * @author lijin
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int left=0;
        int right=nums.length-1;
        while(left+1<right){
            int mid=(left-right)/2+left;  
            if(nums[mid]>target){
                right=mid;
            }else if(nums[mid]<target){
                left=mid;
            }else{
                return mid;
            }
            if(target==nums[left]){
                return left;
            }else if(target==nums[right]){
                return right;
            }
            return -1;
           
        }
    
}
