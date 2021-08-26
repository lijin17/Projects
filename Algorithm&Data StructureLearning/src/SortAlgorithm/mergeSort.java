/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortAlgorithm;
import static SortAlgorithm.InsertSort.insertBinarySort;
import java.util.Arrays;

public class mergeSort {
    public static int[] mergeSort(int[] nums, int low, int high){
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
        return nums;
    }
    
    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <=high) {
            temp[k++] = nums[j++];
        }
        
        for (int x = 0; x < temp.length; x++) {
            nums[x + low] = temp[x];
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums={9,10,1,3,4,2,6,8,5,3};
        mergeSort(nums, 0, nums.length - 1);
        System.out.print(Arrays.toString(nums));
        
    } 
}
