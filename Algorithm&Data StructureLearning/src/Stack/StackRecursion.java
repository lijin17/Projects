/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author lijin
 */
public class StackRecursion {
    public static void test(){
        test1();
    }
    
    public static void test1(){
        System.out.println("这是第一个调用");
        test2();
        System.out.println("第一个调用结束");
    }
    
    public static void test2(){
        System.out.println("这是第二个调用");
        test3();
        System.out.println("第二个调用结束");
    }
    
    public static void test3(){
        System.out.println("这是第三个调用");
       
        System.out.println("第三个调用结束");
    }
    
    public static void main(String[] args){
        test();
    }
}
