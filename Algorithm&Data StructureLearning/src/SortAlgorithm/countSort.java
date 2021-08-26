/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortAlgorithm;

import java.util.Arrays;

/**
 * 时间复杂度：
 * 最好：O(n)
 * 最坏：无意义
 * 平均：O(n+k) k：整数的范围
 * 空间复杂度：O(logn~n)
 * 稳定性：不稳定
 * @author lijin
 */
public class countSort {
    public static void countSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        
        int[] count = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] = count[nums[i]] + 1;
        }
        
        int index = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums={9,10,1,3,4,2,6,8,5,3};
        countSort(nums);
        System.out.print(Arrays.toString(nums));
        
    } 
}
