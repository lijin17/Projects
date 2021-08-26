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
public class QuickSort {
    public static void quickSort(int[] nums,int left, int right){
        if(left<right){
            int pivot=partition(nums,left,right);
            quickSort(nums,left,pivot-1);
            quickSort(nums,pivot+1,right);
        }
    }
    
    public static int partition(int[] nums,int left,int right){
        int pivotIndex=left;
        int pivot=nums[pivotIndex];
        int l=left+1;
        int r=right;
        while(l<=r){
            if(nums[l]>pivot&&nums[r]<pivot){
                swap(nums,l++,r--);
            }
            if(nums[l]<=pivot){
                l++;
            }
            if(nums[r]>=pivot){
                r--;
            }
        }
        swap(nums,pivotIndex,r);
        return r;
    }
    
    public static void swap(int[] nums, int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
    public static void main(String[] args){
        int[] numsTest={10,5,2,1,0};
        quickSort(numsTest,0,numsTest.length-1);
        for(int i=0;i<numsTest.length;i++){
            System.out.println(numsTest[i]);
        }
        
    }
}
