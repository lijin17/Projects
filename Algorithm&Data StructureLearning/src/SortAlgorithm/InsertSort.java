/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortAlgorithm;

import java.util.Arrays;

/**
 * 时间复杂度：O(n^2)
 * 最好：O(n)
 * 最坏：O(n^2)
 * 平均：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 * 
 * @author lijin
 */
public class InsertSort {
    public static void insertSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(nums[j-1]>nums[j]){
                    int temp=nums[j-1];
                    nums[j-1]=nums[j];
                    nums[j]=temp;
                }else{
                    break;
                }
            }
        }
    }
    
/**
 * 时间复杂度：O(nlogn)
 * 最好：O(n)
 * 最坏：O(n^2)
 * 平均：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 * 
 * @author lijin
 */    
    public static void insertBinarySort(int[] nums){
        int temp;//将temp,start, end,mid放在循环外，以节省空间开销
        int start;
        int end;
        int mid;
        for(int i=0;i<nums.length-1;i++){
            temp=nums[i+1];
            start=0;
            end=i;
            while(start<=end){
                mid=(start+end)/2;
                if(temp>nums[mid]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
            for(int j=i;j>end;j--){
                nums[j+1]=nums[j];
            }
            nums[end+1]=temp;
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums={9,10,1,3,4,2,6,8,5,3};
        insertBinarySort(nums);
        System.out.print(Arrays.toString(nums));
        
    } 
}
