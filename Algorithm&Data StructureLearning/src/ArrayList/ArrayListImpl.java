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
public class ArrayListImpl implements IArrayList{
    private int[] data;
    
    private int size;
    
    public ArrayListImpl(){
        this(10);
    }
    
    public ArrayListImpl(int capacity){
        this.data=new int[capacity];
        this.size=0;
    }

    /**
     * time:O(1)
     * @return 
     */
    @Override
    public int capacity() {
        return data.length;
    }

    /**
     * time:O(1)
     * @return 
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * time:O(1)
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * time:O(n)
     * @return 
     */
    @Override
    public void add(int element) {
        add(size,element);
    }

    /**
     * time:O(n)
     * @return 
     */
    @Override
    public void add(int index, int element) {
        
        if(index<0||index>size){
            throw new IllegalArgumentException("index输入错误");
        }
        if(size==data.length){
            resize(size*2);
        }
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        
        data[index]=element;
        size++;
    }

    /**
     * time:O(n)
     * @return 
     */
    @Override
    public boolean contains(int element) {
        for(int i=0;i<size;i++){
            if(data[i]==element){
                return true;
            }
        }
        return false;
    }

    /**
     * time:O(1)
     * @return 
     */
    @Override
    public int get(int index) {
        if(index<0||index>size){
            throw new IllegalArgumentException("index输入错误");
        }
        return data[index];
    }

    /**
     * time:O(1)
     * @return 
     */
    @Override
    public void set(int index, int element) {
        if(index<0||index>size){
            throw new IllegalArgumentException("index输入错误");
        }
        data[index]=element;
    }

    /**
     * time:O(n)
     * @return 
     */
    @Override
    public int remove(int index) {
        if(index<0||index>size){
            throw new IllegalArgumentException("index输入错误");
        }
        int res=data[index];
        for(int i=index+1;i<data.length;i++){
            data[i-1]=data[i];
        }
        size--;
        if(data.length/4==size&&data.length/2!=0){
            resize(data.length/2); 
        }
        return res;
    }

    /**
     * time:O(n)
     * @return 
     */
    @Override
    public void removeElement(int element) {
        int index=-1;
        for(int i=0;i<size;i++){
            if(data[i]==element){
                index=i;
            }
        }
        if(index==-1){
            throw new IllegalArgumentException("元素不存在");
        }
        remove(index);
    }

    /**
     * time:O(n)
     * 
     */
    @Override
    public void print() {
        System.out.println("size: "+size);
        System.out.println("capacity: "+data.length);
        for(int i=0;i<size;i++){
            System.out.print(data[i]+" ");
        }
    }

    @Override
    public void resize(int capacity) {
        int[] temp=new int[capacity];
        for(int i=0;i<size;i++){
            temp[i]=data[i];
        }
        data=temp;
    }
    

}
