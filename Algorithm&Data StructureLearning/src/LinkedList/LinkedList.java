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
public class LinkedList<E> {

    private int size;
    private ListNode dummy;

    public LinkedList() {
        this.dummy = new ListNode(0);
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index输入错误");
        }
        ListNode prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void addFirst(E data) {
        add(data, 0);
    }

    public void addLast(E data) {
        add(data, size);
    }

    public E removeIndex(int index) {
        if (index < 0 || index >= size) {//最大删除到size-1，所以要有=
            throw new IllegalArgumentException("index输入错误");
        }
        ListNode prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        ListNode delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;

        return (E) delNode.data;
    }

    public E removeFirst() {
        return removeIndex(0);
    }

    public E removeLast() {
        return removeIndex(size - 1);
    }

    public boolean removeElement(E data) {
        ListNode prev = dummy;

        while (prev.next != null) {
            if (prev.next.data == data) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            ListNode delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return true;
        }
        return false;
    }

    public boolean addElement(E data) {
        addLast(data);
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index输入错误");
        }
        ListNode curNode = dummy.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return (E) curNode.data;
    }

    public void set(int index, int data) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index输入错误");
        }
        ListNode curNode = dummy.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        curNode.data = data;

    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public boolean contains(E data) {
        ListNode curNode = dummy.next;
        while (curNode != null) {
            if (curNode.data.equals(data) ) {
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    private class ListNode<E> {

        public E data;
        public ListNode next;

        public ListNode(E data) {
            this.data = data;
            this.next = null;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

    }
    
    public void print(){
        ListNode cur=dummy.next;
        while(cur!=null){
            System.out.print(cur.data+" -> ");
            cur=cur.next;
        }
        System.out.println("null");
    }
}
