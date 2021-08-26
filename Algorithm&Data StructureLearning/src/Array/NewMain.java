/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

import java.util.ArrayList;

/**
 *
 * @author lijin
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    
    /**
     * Given an array of non-negative integers arr[]. 
     * The task is to find the largest number in the array which is palindrome. 
     * If no such number exits then print -1.
     * @param args 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums={1,2,4,5,12323,1234321,12321,121};
        int res=findNum(nums);
        System.out.println(res);
    }
    
    public static int findNum(int[] nums){
        int max=-1;
        for(int i=0; i<nums.length; i++){
            if(isPalindrome(nums[i])){
                max=Math.max(max, nums[i]);
            }                     
        }
        
        return max;
    }
    
    public static boolean isPalindrome(int num){
        int i=10;
        ArrayList<Integer> list=new ArrayList<>();
        while(num!=0){
           list.add(num%i);
           num=num/10;
           
        }
        
        for(int j=0; j<list.size(); j++){
            if(list.get(j)!=list.get(list.size()-j-1)){
                return false;
            }
        }
        return true;
    }
    
    
}
