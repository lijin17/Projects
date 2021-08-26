/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.NursingHouseDirectory;

/**
 *
 * @author MyPC1
 */
public class Network {
    private String name;
    private NursingHouseDirectory nursingHouseDirectory;
    
    public Network(){
        nursingHouseDirectory=new NursingHouseDirectory();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NursingHouseDirectory getEnterpriseDirectory() {
        return nursingHouseDirectory;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
