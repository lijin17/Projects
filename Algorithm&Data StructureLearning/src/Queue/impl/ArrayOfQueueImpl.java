/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue.impl;

import Queue.IQueue;

/**
 *
 * @author lijin
 */
public class ArrayOfQueueImpl<E> implements IQueue{
    private E[] data;
    
    private int head;
    
    private int tail;
    
    private int size;
    
    
    
    public ArrayOfQueueImpl(){
        this(10);
    }
    
    public ArrayOfQueueImpl(int capacity){
        
        this.data=(E[]) new Object[capacity];
        this.head=0;
        this.tail=0;
        this.size=0;
    }
    
    

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean offer(Object e) {
        if(tail==data.length){
            resize(tail*2);
        }
        data[tail++]=(E) e;
        size++;
        return true;
        
    }

    @Override
    public Object poll() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        E e=data[head++];
        if(head==data.length){
            head=0;
        }
        size--;
        return e;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        return data[head];
    }

    @Override
    public void print() {
        System.out.println("size:"+size);
        System.out.println("capacity"+data.length);
        for(int i=0;i<tail;i++){
            System.out.print(data[i]+ " ");
        }
        System.out.println();
    }
    
    public void resize(int capacity){
        E[] temp=(E[]) new Object[capacity];
        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
    }
    
}
