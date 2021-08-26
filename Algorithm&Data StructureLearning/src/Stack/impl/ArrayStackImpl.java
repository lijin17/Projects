/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack.impl;

import java.util.EmptyStackException;

/**
 *
 * @author lijin
 */ 
public class ArrayStackImpl<E> implements IArrayStack {
    
    private E[] data;
    
    private int elementCount;
    
    public ArrayStackImpl(){
        this(10);
    }

    public ArrayStackImpl(int capacity) {
        this.data = (E[])new Object[capacity];
        this.elementCount = 0;
    }
    
    
    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public boolean isEmpty() {
        return elementCount==0;
    }

    @Override
    public void push(Object e) {
        if(elementCount==data.length){
            resize(data.length*2);
        }
        data[elementCount++]=(E)e;
    }

    @Override
    public Object pop() {
        if(isEmpty()){
            new EmptyStackException();
        }
        E obj=(E) peek();
        elementCount--;
        data[elementCount]=null;
        return obj;
    }
    

    @Override
    public Object peek() {
        if(isEmpty()){
            new EmptyStackException();
        }
        return data[elementCount-1];
    }

    @Override
    public void print() {
        System.out.println("size:"+elementCount);
        System.out.println("capacity:"+data.length);
        for(int i=0;i<elementCount;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    @Override
    public void resize(int capacity) {
        E[] temp=(E[]) new Object[capacity];
        for(int i=0;i<elementCount;i++){
            temp[i]=data[i];
        }
        data=temp;
    }
    
}
