/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap.impl;

/**
 *
 * @author lijin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaxHeapImpl<Integer> maxHeap = new MaxHeapImpl<>();
        Integer[] nums = {2, 23, 30, 8, 32, 31, 41, 1, 15};
        for(Integer num : nums) {
            maxHeap.offer(num);
        }
        maxHeap.print();
    }
    
}
