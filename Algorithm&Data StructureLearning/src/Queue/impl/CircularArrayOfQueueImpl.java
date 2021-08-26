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
public class CircularArrayOfQueueImpl<E> implements IQueue{

    private E[] data;
    
    private int head;
    
    private int tail;
    
    public CircularArrayOfQueueImpl(){
        this(10);
    }
    
    public CircularArrayOfQueueImpl(int capacity){
        this.data=(E[]) new Object[capacity];
        this.head=0;
        this.tail=0;
    }
    
    @Override
    public int size() {//****************
        return (tail-head+data.length)%data.length;
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public boolean offer(Object e) {
        data[tail]=(E) e;
        tail=(tail+1)%data.length;
        if(tail==head){
            resize(data.length*2);
        }
        return true;
    }

    @Override
    public Object poll() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        E obj=data[head];
        data[head]=null;
        head=(head+1)%data.length;
        return obj;
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
        System.out.println("size:"+(tail-head+data.length)%data.length);
        System.out.println("capacity"+data.length);
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+ " ");
        }
        System.out.println();
    }
    
    public void resize(int capacity){
        E[] temp=(E[]) new Object[capacity];
        for(int i=0;i<data.length;i++){
            temp[i]=data[(i+head)%data.length];
        }
        head=0;
        tail=data.length;
        data=temp;
    }
    
}
