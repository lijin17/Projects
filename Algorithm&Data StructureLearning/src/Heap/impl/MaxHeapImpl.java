/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap.impl;

import Heap.IMaxHeap;

/**
 *
 * @author lijin
 */
public class MaxHeapImpl<E extends Comparable<E>> implements IMaxHeap {
    private int size;
    
    private int capacity;
    
    private E[] data;
    
    public MaxHeapImpl(E[] data) {
        this.capacity = data.length;        
        this.data = data;    
        this.size = data.length;
        heapify(data);
    }
    
    public MaxHeapImpl() {
        this.capacity=16;
        this.size = 0;
        this.data = (E[]) new Comparable[capacity];
    }
    
    private void heapify(E[] data) {
        for(int i = getParentIndex(size-1); i >= 0; i--){
            siftDownHeapify(i);
        }
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
        if(size == capacity) {
            expandCapcity();
        }
        data[size] = (E) e;
        size++; // 必须写在siftup前面
        siftUp();
        return true;
    }

    @Override
    public Object poll() {
        if(size == 0) {
            throw new IllegalArgumentException("堆为空");
        }
        E item = data[0];       
        data[0] = data[size - 1];
        data[size - 1] = null;
        size--;
        siftDown();
        return item;
    }

    @Override
    public Object peek() {
        if(size == 0) {
            throw new IllegalArgumentException("堆为空");
        }
        return data[0];
    }

    @Override
    public void print() {
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
    }
    
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2; 
    }
    
    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }
    
    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }
    
    private E leftChild(int index) {
        return data[getLeftChildIndex(index)];
    }
    
    private E rightChild(int index) {
        return data[getRightChildIndex(index)];
    }
    
    private E parent(int index){
        return data[getParentIndex(index)];
    }
    
    private void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    
    private void siftUp() {
        int index = size - 1;
        while(getParentIndex(index) >= 0 && parent(index).compareTo(data[index]) < 0) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }
    
    private void siftDown() {
        int index = 0;
        while(getLeftChildIndex(index) < size) {
            int biggerChildIndex = getLeftChildIndex(index);
            if(getRightChildIndex(index) < size && leftChild(index).compareTo(rightChild(index)) < 0) {
                biggerChildIndex = getRightChildIndex(index);
            }
            
            if(data[index].compareTo(data[biggerChildIndex]) > 0) {
                break;
            }else {
                swap(index, biggerChildIndex);
            }
            index = biggerChildIndex;
        }
    }
    
    private void siftDownHeapify(int index) {
        while(getLeftChildIndex(index) < size) {
            int biggerChildIndex = getLeftChildIndex(index);
            if(getRightChildIndex(index) < size && leftChild(index).compareTo(rightChild(index)) < 0) {
                biggerChildIndex = getRightChildIndex(index);
            }
            
            if(data[index].compareTo(data[biggerChildIndex]) > 0) {
                break;
            }else {
                swap(index, biggerChildIndex);
            }
            index = biggerChildIndex;
        }
    }
    
    private void expandCapcity() {
        E[] temp = (E[]) new Comparable[capacity * 2];
        for(int i = 0; i < capacity; i++) {
            temp[i] = data[i];
        }
        capacity = capacity * 2;
        data = temp;
    }
    
    
}
