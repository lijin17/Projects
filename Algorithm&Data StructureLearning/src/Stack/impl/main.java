/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack.impl;

/**
 *
 * @author lijin
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArrayStackImpl<Integer> stack=new ArrayStackImpl<>();
       stack.push(1);
       stack.print();
       for(int i=0;i<10;i++){
           stack.push(i);
       }
       System.out.println(stack.peek());
       stack.print();
       stack.pop();
       stack.print();
       
       System.out.println("-----------------------------");
       LinkedListStackImpl<Integer> lstack=new LinkedListStackImpl<>();
       lstack.push(1);
       lstack.print();
       for(int i=0;i<10;i++){
           lstack.push(i);
       }
       System.out.println(lstack.peek());
       lstack.print();
       lstack.pop();
       lstack.print();
    }
    
    
    
}
