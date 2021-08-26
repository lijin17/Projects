/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

/**
 *
 * @author lijin
 */
public interface IMaxHeap<E> {
    /*
        实际占用大小
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
    
    boolean offer(E e);
    
    /*
    删除元素，出栈
    @return
    */
    
    E poll();
    
    /*
    查看栈顶
    @return
    */
    
    E peek();
    
    /*
    打印数据和结果
    */
    
    void print();
}
