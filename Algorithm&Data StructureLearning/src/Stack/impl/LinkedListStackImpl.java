/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack.impl;

import java.util.LinkedList;



/**
 *
 * @author lijin
 */
public class LinkedListStackImpl<E> implements ILinkedListStack<E> {
    
    private LinkedList<E> linkedList;
    
    public LinkedListStackImpl() {
        this.linkedList=new LinkedList<E>();
    }   

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public void print() {
        System.out.println("size:"+linkedList.size());
        
        for(int i=0;i<linkedList.size();i++){
            System.out.print(linkedList.get(i)+" ");
        }
        System.out.println();
    }
    
}
