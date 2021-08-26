/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortAlgorithm;

import java.util.Arrays;

/**
 *
 * @author lijin
 */
/**
 * 时间复杂度： 最好：O(n) 最坏：O(n^2) 平均：O(n^2) 空间复杂度：O(1)
 *
 * @author lijin
 */
public class BubbleSort {
    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    private static void bubbleSortBest(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            flag = false;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {9, 10, 1, 3, 4, 2, 6, 8, 5};
        bubbleSort(nums);
        System.out.print(Arrays.toString(nums));

    }
}
