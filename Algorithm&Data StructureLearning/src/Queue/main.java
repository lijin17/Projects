/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import Queue.impl.ArrayOfQueueImpl;
import Queue.impl.CircularArrayOfQueueImpl;
import Queue.impl.LinkedListOfQueue;

/**
 *
 * @author lijin
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        IQueue<Integer> queue=new LinkedListOfQueue();
        for(int i=0;i<8;i++){
            queue.offer(i);
            queue.print();
        }
        queue.poll();
        queue.print();
        System.out.println(queue.peek());
        
        System.out.println("--------------------------------");
        IQueue<Integer> Aqueue=new ArrayOfQueueImpl();
        for(int i=0;i<11;i++){
            Aqueue.offer(i);
            Aqueue.print();
        }
        System.out.println(Aqueue.poll());
        Aqueue.print();
        System.out.println(Aqueue.peek());
        
        System.out.println("--------------------------------");
        IQueue<Integer> Cqueue=new CircularArrayOfQueueImpl();
        for(int i=0;i<9;i++){
            Cqueue.offer(i);
            
        }
        Cqueue.print();
        Cqueue.poll();
        Cqueue.poll();
        Cqueue.poll();
        Cqueue.print();
        Cqueue.offer(11);
        Cqueue.offer(21);
        Cqueue.offer(31);
        Cqueue.print();
        Cqueue.offer(41);
        Cqueue.print();
        System.out.println(Cqueue.peek());
    }
    
}
