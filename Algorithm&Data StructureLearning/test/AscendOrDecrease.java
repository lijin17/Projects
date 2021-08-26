/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lijin
 */
public class AscendOrDecrease {
    public static String AscendOrDecrease(int[] arr) {
        if (arr == null || arr.length == 0) {
            return "Empty array";
        }
        boolean bigger = false;
        boolean smaller = false;
        
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                bigger = true;
            }
            if (arr[i] > arr[i + 1]) {
                smaller = true;
            }
            if (bigger && smaller) {
                return "Neither ascending nor decreasing";
            }
        }
        if (bigger) {
            return "Ascending";
        }
        if (smaller) {
            return "Decreasing";
        }
        
        
        return "Array with all same elements";
    }

   

    public static void main(String[] args) {
        int[] arr = {};
        String result = AscendOrDecrease(arr);
        System.out.print(result);
    }
}
