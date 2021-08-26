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
public class StackLevel {
    public static int level=1;
    public static void level(){
        level++;
        level();
    }
    public static void main(String[] args){
        try{
            level();
        }catch(StackOverflowError e){
            System.out.println(level);
        }
        
    }
}
