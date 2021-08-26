/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class NHSystem extends Organization{
    
    //最高系统，存放networklist
    private static NHSystem nhSystem;
    private ArrayList<Network> networkList;
    
    public static NHSystem getInstance(){
        if(nhSystem==null){
            nhSystem=new NHSystem();
        }
        return nhSystem;
    }
    
    //创建添加network
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    
    private NHSystem(){
        super(null);
        networkList=new ArrayList<Network>();
    }

    
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    //
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        
        for(Network network:networkList){
            
        }
        return true;
    }
}
