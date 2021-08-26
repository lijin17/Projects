/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import java.util.Random;

/**
 *
 * @author lijin
 */
public class ReservoirSampling {//以下是从stream中的n个元素中取k个，等概率
    public int[] reservoirSampling(int[] stream1, int k1){
        int[] stream={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};//例子：数据流
        int k=3;//存储前k个数字
        Random rd=new Random();
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=stream[i];
        }
        
        for(int j=k;j<stream.length;j++){
            int random=rd.nextInt(j+1);
            if(random<k){
                res[random]=stream[j];
            }
        }
        
        return res;
    }
    
    int[] stream={};
        int k=3;//存储前k个数字
        Random rd=new Random();
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=stream[i];
        }   
        for(int j=k;j<stream.length;j++){
            int random=rd.nextInt(j+1);
            if(random<k){
                res[random]=stream[j];
            }
        }
        
        return res;
    }
    
    
}

