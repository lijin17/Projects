/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lijin
 */
public class countNum {
    public static int countNum(int n, int num) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int cur = i;
            if(splitAndCheck(cur, num) == true) {
                //System.out.println(i);
                result++;
            }
        }
        return result;
    }

    public static boolean splitAndCheck(int s, int num) {
        int x;
        while (s != 0) {
            x = s % 10;
            if (x == num) {
                System.out.println(s);
                return true;
            }
            s = s / 10;
        }
        return false;
    }

    public static void main(String[] args) {
        int count = countNum(50, 3);
        System.out.print(count);
    }
}
