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
public class LinkedListOfQueue implements IQueue{
    private ListNode head;
    
    private ListNode tail;
    
    private int size;

    public LinkedListOfQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size==0){
           return true; 
        }else{
            return false;
        }
        
    }

    @Override
    public boolean offer(Object e) {
        if(tail==null){
            tail=new ListNode(e);
            head=tail;
        }else{
            tail.next=new ListNode(e);
            tail=tail.next;
        }
        size++;
        return true;           
    }

    @Override
    public Object poll() {
        if(isEmpty()){
            return new IllegalArgumentException("队列为空");
        }
        
        ListNode res=head;
        head=head.next;
        res.next=null;//******
        
        if(head==null){
            tail=null;
        }
        size--;
        return res.data;       
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            return new IllegalArgumentException("队列为空");
        }
        return head.data;
    }

    @Override
    public void print() {       
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.data+" -> ");
            cur=cur.next;
        }
        System.out.println("null");
    }
    
    
    private class ListNode<E>{
        public E data;
        public ListNode next;
        public ListNode(E data){
            this.data=data;
            this.next=null;
        }
    }
    
}
