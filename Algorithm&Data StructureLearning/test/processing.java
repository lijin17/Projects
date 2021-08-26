
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lijin
 */
public class processing {
    public static int process(int[] arr, int n) {
        int max = getMax(arr);
        int[] countArr = new int[max + 1];    
        for(int a : arr) {
            countArr[a]++;
        }
        Arrays.sort(countArr);
        int max_n = countArr[max] - 1;
        int coolSpace = max_n * n;
        
        for(int i = max - 1; i >= 0 && countArr[i] > 0; i--) {
            coolSpace -= Math.min(max_n, countArr[i]);
        }
        
        return coolSpace > 0 ? arr.length + coolSpace : arr.length;
        
    }

    public static int getMax(int [] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
   

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,8,99};
        int result = process(arr, 2);
        System.out.print(result);
    }
}
