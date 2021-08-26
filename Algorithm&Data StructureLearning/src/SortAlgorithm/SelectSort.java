/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortAlgorithm;

import java.util.Arrays;

/**
 * 时间复杂度：O(n^2)
 * 最好：O(n^2)
 * 最坏：O(n^2)
 * 平均：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 * @author lijin
 */

public class SelectSort {
    public static void selectSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int minIndex=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){//!!!!!!
                int temp=nums[minIndex];
                nums[minIndex]=nums[i];
                nums[i]=temp;
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums={9,10,1,3,4,2,6,8,5};
        selectSort(nums);
        System.out.print(Arrays.toString(nums));
        
    } 
}
