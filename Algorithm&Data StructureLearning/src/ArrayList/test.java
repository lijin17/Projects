/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayList;

/**
 *
 * @author lijin
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayListImpl arrayList=new ArrayListImpl();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.print();
        arrayList.add(0, 0);
        arrayList.print();
        arrayList.remove(1);
        arrayList.print();
        arrayList.removeElement(0);
        arrayList.print();
        System.out.println(arrayList.get(0));
        arrayList.set(0, 1);
        arrayList.print();
        
    }
    
}
