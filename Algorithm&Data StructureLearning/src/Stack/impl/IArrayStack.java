/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack.impl;

/**
 *
 * @author lijin
 */
public interface IArrayStack<E> {
    /*
    容量大小
    @return
    */
    int capacity();
    
    /*
    实际占用大小
    @return
    */
    int size();
    
    /*
    判断是否为空
    @return
    */
    boolean isEmpty();
    
    /*
    插入数据，入栈
    @param
    */
    void push(E e);
    
    /*
    删除元素，出栈；
    @return
    
    */
    E pop();
    
    /*
    查看栈顶
    */   
    E peek();
    
    /*
    打印数据和结果
    */
    void print();
    
    /*
    改变capacity的大小
    @param capacity
    */
    void resize(int capacity);
}
