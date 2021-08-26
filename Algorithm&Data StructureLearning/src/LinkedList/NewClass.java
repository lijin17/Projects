/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author lijin
 */
public class NewClass {
    public static void main(String[] args){
        LinkedList<Integer> list=new LinkedList<>();
        list.addElement(1);
        list.addElement(2);
        list.print();
        list.addFirst(9);
        list.print();
        list.removeElement(2);
        list.print();
    }
}
